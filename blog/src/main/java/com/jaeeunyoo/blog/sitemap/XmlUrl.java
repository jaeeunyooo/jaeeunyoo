package com.jaeeunyoo.blog.sitemap;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@XmlAccessorType(value = XmlAccessType.NONE)
@XmlRootElement(name = "url")
@Getter
@NoArgsConstructor
public class XmlUrl {

    private static final DateTimeFormatter YYYY_MM_DD_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Getter
    @AllArgsConstructor
    public enum Priority {
        HIGH("1.0"),
        MEDIUM("0.5");

        private final String value;
    }

    @Getter
    @AllArgsConstructor
    public enum ChangeFrequency {
        ALWAYS("always"),
        HOURLY("hourly"),
        DAILY("daily"),
        WEEKLY("weekly"),
        MONTHLY("monthly"),
        YEARLY("yearly"),
        NEVER("never");

        private final String value;
    }

    @XmlElement
    private String loc;

    @XmlElement
    private String lastmod;

    @XmlElement
    private String changefreq;

    @XmlElement
    private String priority;

    public XmlUrl(String loc, LocalDate lastModifyDate, Priority priority, ChangeFrequency changeFrequency) {
        this.loc = loc;
        this.priority = priority.getValue();
        this.lastmod = lastModifyDate.format(YYYY_MM_DD_FORMATTER);
        this.changefreq = changeFrequency.getValue();
    }
}
