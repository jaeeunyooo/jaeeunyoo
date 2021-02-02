package com.jaeeunyoo.blog.sitemap;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.NoArgsConstructor;

@XmlAccessorType(value = XmlAccessType.NONE)
@XmlRootElement(name = "url")
@Getter
@NoArgsConstructor
public class XmlUrl {

    private static final DateTimeFormatter YYYY_MM_DD_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @XmlElement
    private String loc;

    @XmlElement
    private String lastmod;

    public XmlUrl(String loc, LocalDate lastModifyDate) {
        this.loc = loc;
        this.lastmod = lastModifyDate.format(YYYY_MM_DD_FORMATTER);
    }
}
