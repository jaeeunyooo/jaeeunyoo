<#import "../common/head.ftl" as head>
<#import "../common/sidebar.ftl" as sidebar>
<#import "../common/topbar.ftl" as topbar>
<#import "../common/pannel.ftl" as pannel>
<#import "../common/footer.ftl" as footer>
<#import "../common/trending_tags.ftl" as trending_tags>

<!DOCTYPE html>
<html lang="en">

<head>
  <@head.common_meta/>
  <@head.cdn_jsdelivr_net/>
  <@head.cdnjs_cloudflare_com/>
  <@head.uicdn_toast_com/>
  <link rel="preload" href="/static/css/home.css" as="style">
  <link rel="stylesheet" href="/static/css/home.css">
  <title>기계는 거짓말을 하지 않는다</title>
  <script src="//cdn.jsdelivr.net/npm/jquery@3/dist/jquery.min.js"></script>
</head>
<body data-spy="scroll" data-target="#toc">
<@sidebar.common_sidebar selectedMenu="POSTS"/>
<@topbar.posts_topbar/>
<div id="main-wrapper">
  <div id="main">
    <div class="row">
      <div class="col-12 col-lg-11 col-xl-8">
        <div id="page" class="post pb-5 pl-1 pr-1 pl-sm-2 pr-sm-2 pl-md-4 pr-md-4 mb-md-4">
          <div id="post-list">
            <#if postPage??>
              <#if postPage.content??>
                <#list postPage.content as post>
                  <div class="post-preview">
                    <h1>
                      <a href="/post/${post.postId}">${post.postTitle}</a>
                    </h1>
                    <div class="post-content">
                      <p>${post.postContent}</p>
                    </div>
                    <div class="post-meta text-muted d-flex justify-content-between">
                      <div>
                        <i class="far fa-calendar fa-fw"></i>
                        <span class="timeago " data-toggle="tooltip" data-placement="bottom" title="" data-original-title="${post.registerDateTime}">${post.formattedRegisterDate}<i class="unloaded">${post.registerDateTime}</i></span>
                          <i class="far fa-clock fa-fw"></i>
                          <span class="readtime" data-toggle="tooltip" data-placement="bottom" title="" data-original-title="${post.wordCount} words">${post.minuteToRead} min</span>
                      </div>
<#--                      <div class="pin">-->
<#--                        <i class="fas fa-thumbtack fa-fw"></i>-->
<#--                        <span>Pinned</span>-->
<#--                      </div>-->
                    </div>
                  </div>
                </#list>
              </#if>
            </#if>
          </div>
          <ul class="pagination mt-4 mb-0 pl-lg-2">
            <#if (postPage?? && postPage.numberOfElements > 0)>
              <li class="page-item<#if postPage.first> disabled</#if>">
                <a class="page-link btn-box-shadow" aria-label="previous-page" data-pagenumber="0">
                  <i class="fas fa-angle-left"></i>
                </a>
              </li>
              <#if (postPage.totalPages > 10)>
                <#list 0..9 as pageNumber>
                  <#if pageNumber == postPage.number>
                    <li class="page-item active">
                      <a class="page-link btn-box-shadow" data-pagenumber="${pageNumber?c}">${pageNumber + 1}</a>
                    </li>
                  <#else>
                    <li class="page-item">
                      <a class="page-link btn-box-shadow" data-pagenumber="${pageNumber?c}">${pageNumber + 1}</a>
                    </li>
                  </#if>
                </#list>
              <#else>
                <#list 0..(postPage.totalPages-1) as pageNumber>
                  <#if pageNumber == postPage.number>
                    <li class="page-item active">
                      <a class="page-link btn-box-shadow" data-pagenumber="${pageNumber?c}">${pageNumber + 1}</a>
                    </li>
                  <#else>
                    <li class="page-item">
                      <a class="page-link btn-box-shadow" data-pagenumber="${pageNumber?c}">${pageNumber + 1}</a>
                    </li>
                  </#if>
                </#list>
              </#if>
              <li class="page-item<#if postPage.last> disabled</#if>">
                <a class="page-link btn-box-shadow" aria-label="next-page" data-pagenumber="<#if (postPage.totalPages > 10)>11<#else>${postPage.totalPages - 1}</#if>">
                  <i class="fas fa-angle-right"></i>
                </a>
              </li>
            </#if>
          </ul>
        </div> <!-- #page -->
      </div><!-- .col-12 -->
      <@pannel.common_pannel false/>
    </div>
    <@footer.common_footer/>
  </div>
  <@trending_tags.trending_tags_m/>
</div>
<script id="_postListItemTemplate" type="text/x-jquery-tmpl">
  <div class="post-preview">
    <h1>
      <a href="/post/${r'${postId}'}">${r'${postTitle}'}</a>
    </h1>
    <div class="post-content">
      <p>${r'${postContent}'}</p>
    </div>
    <div class="post-meta text-muted d-flex justify-content-between">
      <div>
        <i class="far fa-calendar fa-fw"></i>
        <span class="timeago " data-toggle="tooltip" data-placement="bottom" title="" data-original-title="${r'${registerDateTime}'}">${r'${formattedRegisterDate}'}<i class="unloaded">${r'${registerDateTime}'}</i></span>
        <i class="far fa-clock fa-fw"></i>
        <span class="readtime" data-toggle="tooltip" data-placement="bottom" title="" data-original-title="${r'${wordCount}'} words">${r'${minuteToRead}'} min</span>
      </div>
    </div>
  </div>
</script>
<script id="_paginationTemplate" type="text/x-jquery-tmpl">
    <li class="page-item{{if first}} disabled{{/if}}">
      <a class="page-link btn-box-shadow" aria-label="previous-page" data-pagenumber="${r'${previousPageNumber}'}">
        <i class="fas fa-angle-left"></i>
      </a>
    </li>
    {{each(index, value) pageRange}}
      {{if value == number}}
        <li class="page-item active">
          <a class="page-link btn-box-shadow" data-pagenumber="${r'${value}'}">${r'${value + 1}'}</a>
        </li>
      {{else}}
        <li class="page-item">
          <a class="page-link btn-box-shadow" data-pagenumber="${r'${value}'}">${r'${value + 1}'}</a>
        </li>
      {{/if}}
    {{/each}}
    <li class="page-item{{if last}} disabled{{/if}}">
      <a class="page-link btn-box-shadow" aria-label="next-page" data-pagenumber="${r'${nextPageNumber}'}">
        <i class="fas fa-angle-right"></i>
      </a>
    </li>
</script>
<script src="//cdn.jsdelivr.net/npm/simple-jekyll-search@1.7.3/dest/simple-jekyll-search.min.js"></script>
<script src="//cdn.jsdelivr.net/combine/npm/popper.js@1.15.0,npm/bootstrap@4/dist/js/bootstrap.min.js"></script>
<script src="/webjars/jquery-tmpl/beta1.0.0/jquery.tmpl.min.js"></script>
<script src="/static/js/lib/home.min.js"></script>
<script src="/static/js/util/jaeeunyoo.blog.util.CommonUtil.js"></script>
<#--<script src="/static/js/util/jaeeunyoo.blog.util.SearchResultUtil.js"></script>-->
<script src="/static/js/jaeeunyoo.blog.PostsView.js"></script>
<script>
  $(function () {
    // jaeeunyoo.SearchResultUtil.init();
    jaeeunyoo.blog.PostsView.init({});
  });
</script>
</body>
</html>