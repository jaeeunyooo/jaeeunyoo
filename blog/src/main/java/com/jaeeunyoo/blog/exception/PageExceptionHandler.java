package com.jaeeunyoo.blog.exception;

import com.jaeeunyoo.blog.domain.tag.application.TagService;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RequiredArgsConstructor
public class PageExceptionHandler extends ResponseEntityExceptionHandler {

    private final TagService tagService;

    @ExceptionHandler(UnauthorizedException.class)
    protected String handleUnauthorizedException(HttpServletResponse httpServletResponse, Model model) {
        return "redirect:/sign-in";
    }

    @ExceptionHandler(ForbiddenException.class)
    protected String handleForbiddenException(HttpServletResponse httpServletResponse, Model model) {
        httpServletResponse.setStatus(HttpStatus.FORBIDDEN.value());
        model.addAttribute("httpStatus", HttpStatus.FORBIDDEN.value());
        model.addAttribute("trendingTags", tagService.getTrendingTags());
        return "error/4xx";
    }

    @ExceptionHandler(NotFoundException.class)
    protected String handleNotFoundException(HttpServletResponse httpServletResponse, Model model) {
        httpServletResponse.setStatus(HttpStatus.NOT_FOUND.value());
        model.addAttribute("httpStatus", HttpStatus.NOT_FOUND.value());
        model.addAttribute("trendingTags", tagService.getTrendingTags());
        return "error/4xx";
    }
}
