import java.util.Arrays;
import java.util.List;

/**
 * Data class 101.
 */
public class Novel {
    static String[] websites = {"Wuxiaworld", "Royal Road", "Gravity Tales", "Volare Novels",
            "Light Novels Translations", "WordExcerpt", "Misty Cloud Translations", "BoxNovel"};
    private String chapterLinkSelecter;
    private String titleHostName;
    private String url;
    private String host;
    private String chapterContainer;

    public Novel(String domain, String urla) {
        url = urla;
        List<String> blacklistedTags = null;
        switch (domain) {
            case "wuxiaworld": //compared from websites[] with whitespaces removed and lowercase
                this.host = "https://wuxiaworld.com/"; //Website URL
                this.chapterLinkSelecter = "#accordion .chapter-item"; //Table of contents chapter links
                this.chapterContainer = ".p-15 .fr-view"; //chapter text
                this.titleHostName = "-WuxiaWorld"; //From the tab title with whitespaces removed
                blacklistedTags = Arrays.asList("a.chapter-nav");
                break;
            case "royalroad":
                this.host = "https://www.royalroad.com/";
                this.chapterLinkSelecter = ".table td:not([class])";
                this.chapterContainer = ".chapter-content";
                this.titleHostName = "-Royal-Road";
                break;
            case "gravitytales":
                this.host = "http://gravitytales.com/";
                this.chapterLinkSelecter = ".table td";
                this.chapterContainer = "#chapterContent";
                this.titleHostName = "-Gravity-Tales";
                url = urla + "/chapters"; //gravity tales' chapter list is at gravitytales.com/NOVEL/chapters
                break;
            case "volarenovels":
                this.host = "https://volarenovels.com/";
                this.chapterLinkSelecter = "#accordion .chapter-item a";
                this.chapterContainer = ".jfontsize_content.fr-view";
                this.titleHostName = "-volare-novels";
                blacklistedTags = Arrays.asList("a.chapter-nav", "div[id^=div-gpt-ad]", "span[style=font-size: 0]", "span[class=hidden-text]");
                break;
            case "wordexcerpt":
                this.host = "https://wordexcerpt.com/";
                this.chapterLinkSelecter = ".listing-chapters_wrap a[href^=" + urla + "]";
                this.chapterContainer = ".text-left";
                this.titleHostName = "-WordExcerpt";
                blacklistedTags = Arrays.asList("center", "meta", "script");
                break;
            case "lightnovelstranslations":
                this.host = "https://lightnovelstranslations.com/";
                this.chapterLinkSelecter = ".entry-content a[href^=" + urla + "]:not(a[rel])";
                this.chapterContainer = ".entry-content";
                this.titleHostName = "";
                blacklistedTags = Arrays.asList("div.code-block", ".sharedaddy", "#textbox");
                break;
            case "boxnovel":
                this.host = "https://boxnovel.com/";
                this.chapterLinkSelecter = ".listing-chapters_wrap a";
                this.chapterContainer = ".text-left";
                this.titleHostName = "";
                blacklistedTags = Arrays.asList("div.code-block");
                break;

        }
        if (!(blacklistedTags == null)) {
            Shared.blacklistedTags.clear();
            Shared.blacklistedTags.addAll(blacklistedTags);
        }
    }

    String getChapterLinkSelector() {
        return this.chapterLinkSelecter;
    }

    String getTitleHostName() {
        return this.titleHostName;
    }

    String getUrl() {
        return this.url;
    }

    String getHost() {
        return this.host;
    }

    String getChapterContainer() {
        return this.chapterContainer;
    }
}
