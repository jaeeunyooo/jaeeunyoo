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
  <link rel="preload" href="/static/css/post.css" as="style">
  <link rel="stylesheet" href="/static/css/post.css">
  <link rel="stylesheet" href="/static/css/lib/androidstudio.min.css">
  <title>기계는 거짓말을 하지 않는다</title>
  <script src="//cdn.jsdelivr.net/npm/jquery@3/dist/jquery.min.js"></script>
</head>
<body data-spy="scroll" data-target="#toc">
<@sidebar.common_sidebar selectedMenu="POSTS"/>
<@topbar.post_topbar/>
<div id="main-wrapper">
  <div id="main">
    <div class="row">
      <div id="post-wrapper" class="col-12 col-lg-11 col-xl-8">
        <div class="post pl-1 pr-1 pl-sm-2 pr-sm-2 pl-md-4 pr-md-4">
          <h1 data-toc-skip="">${post.postTitle}</h1>
          <div class="post-meta text-muted d-flex flex-column">
            <div>
              <span class="timeago " data-toggle="tooltip" data-placement="bottom" title="" data-original-title="${post.modifyDateTime}">${post.formattedModifyDate}<i class="unloaded">${post.modifyDateTime}</i></span> by
              <span class="author">Jaeeun Yoo</span>
            </div>
            <div>
              <span class="readtime" data-toggle="tooltip" data-placement="bottom" title="" data-original-title="${post.wordCount} words">${post.minuteToRead} min</span>
              <span>  </span>
              <a href="/post/${post.postId}/edit">
                <i class="fa fa-file fa-fw mr-1" style="display: inline"></i>
              </a>
            </div>
          </div>
          <div id="_postContent" class="post-content">${post.postContentHtml}</div>

          <div class="post-tail-wrapper text-muted">
            <!-- categories -->
            <div class="post-meta mb-3">
              <#if categories??>
                <i class="far fa-folder-open fa-fw mr-1"></i>
                <#list categories as category>
                  <#if category_has_next>
                    <a href="/category/${category.categoryId}">${category.categoryName}</a><span> > </span>
                  <#else>
                    <a href="/category/${category.categoryId}">${category.categoryName}</a>
                  </#if>
                </#list>
              </#if>
            </div>
            <!-- tags -->
            <div class="post-tags">
              <#if postTags??>
                <#list postTags as tag>
                  <#if tag_index == 0>
                    <i class="fa fa-tags fa-fw mr-1"></i>
                  </#if>
                  <a href="/tag/${tag.tagId}" class="post-tag no-text-decoration">${tag.tagName}</a>
                </#list>
              </#if>
            </div>
            <div class="post-tail-bottom d-flex justify-content-between align-items-center mt-3 pt-5 pb-2">
              <div class="license-wrapper">This post is licensed under<a href="https://creativecommons.org/licenses/by/4.0/">CC BY 4.0</a>by the author.</div>
              <div class="share-wrapper">
                <span class="share-label text-muted mr-1">Share</span>
                <span class="share-icons">
                  <a href="https://twitter.com/intent/tweet?text=Getting Started - Chirpy&amp;url=${url}/post/${post.postId}" data-toggle="tooltip" data-placement="top" title="" target="_blank" rel="noopener" aria-label="Twitter" data-original-title="Twitter">
                    <i class="fa-fw fab fa-twitter"></i>
                  </a>
                  <a href="https://www.facebook.com/sharer/sharer.php?title=Getting Started - Chirpy&amp;u=${url}/post/${post.postId}" data-toggle="tooltip" data-placement="top" title="" target="_blank" rel="noopener" aria-label="Facebook" data-original-title="Facebook">
                    <i class="fa-fw fab fa-facebook-square"></i>
                  </a>
                  <a href="https://telegram.me/share?text=Getting Started - Chirpy&amp;url=${url}/post/${post.postId}" data-toggle="tooltip" data-placement="top" title="" target="_blank" rel="noopener" aria-label="Telegram" data-original-title="Telegram">
                    <i class="fa-fw fab fa-telegram"></i>
                  </a>
                  <i class="fa-fw fas fa-link small" onclick="copyLink()" data-toggle="tooltip" data-placement="top" title="" data-original-title="Copy link"></i>
                 </span>
              </div>
            </div><!-- .post-tail-bottom -->
          </div><!-- div.post-tail -->
        </div> <!-- .post -->
      </div> <!-- #post-wrapper -->
      <@pannel.common_pannel true/>
    </div>
    <div class="row">
      <div class="col-12 col-lg-11 col-xl-8">
<#--        <div id="post-extend-wrapper" class="pl-1 pr-1 pl-sm-2 pr-sm-2 pl-md-4 pr-md-4">-->
<#--          <!---->
<#--           Recommend the other 3 posts according to the tags and categories of the current post,-->
<#--           if the number is not enough, use the other latest posts to supplement.-->

<#--           v2.0-->
<#--           https://github.com/cotes2020/jekyll-theme-chirpy-->
<#--           © 2019 Cotes Chung-->
<#--           Published under the MIT License-->
<#--          &ndash;&gt;-->
<#--          <!-- The total size of related posts  &ndash;&gt;-->
<#--          <!-- An random integer that bigger than 0  &ndash;&gt;-->
<#--          <!-- Equals to TAG_SCORE / {max_categories_hierarchy}  &ndash;&gt;-->
<#--          <!-- Fill with the other newlest posts  &ndash;&gt;-->
<#--          <div id="related-posts" class="mt-5 mb-2 mb-sm-4">-->
<#--            <h3 class="pt-2 mt-1 mb-4 ml-1" data-toc-skip="">Further Reading</h3>-->
<#--            <div class="card-deck mb-4">-->
<#--              <div class="card">-->
<#--                <a href="/posts/write-a-new-post/">-->
<#--                  <div class="card-body">-->
<#--                    <!---->
<#--                      Date format snippet-->

<#--                      v2.4.1-->
<#--                      https://github.com/cotes2020/jekyll-theme-chirpy-->
<#--                      © 2020 Cotes Chung-->
<#--                      MIT License-->
<#--                    &ndash;&gt;-->
<#--                    <span class="timeago small">Aug 8, 2019<i class="unloaded">2019-08-08T14:10:00+08:00</i></span>-->
<#--                    <h3 class="pt-0 mt-1 mb-3" data-toc-skip="">Writing a New Post</h3>-->
<#--                    <div class="text-muted small">-->
<#--                      <p>-->
<#--                        Naming and Path-->
<#--                        Create a new file named YYYY-MM-DD-TITLE.EXTENSION and put it in the _posts/ of the root directory. Please note that the EXTENSION must be one of md and markdown.-->
<#--                        Front Matter-->
<#--                        Ba...-->
<#--                      </p>-->
<#--                    </div>-->
<#--                  </div>-->
<#--                </a>-->
<#--              </div>-->
<#--            </div> <!-- .card-deck &ndash;&gt;-->
<#--          </div> <!-- #related-posts &ndash;&gt;-->

<#--          <!---->
<#--            Navigation buttons at the bottom of the post.-->

<#--            v2.1-->
<#--            https://github.com/cotes2020/jekyll-theme-chirpy-->
<#--            © 2020 Cotes Chung-->
<#--            MIT License-->
<#--          &ndash;&gt;-->
<#--          <div class="post-navigation d-flex justify-content-between">-->
<#--            <a href="/posts/write-a-new-post/" class="btn btn-outline-primary">-->
<#--              <p>Writing a New Post</p>-->
<#--            </a>-->
<#--            <a href="/posts/customize-the-favicon/" class="btn btn-outline-primary">-->
<#--              <p>Customize the Favicon</p>-->
<#--            </a>-->
<#--          </div>-->
<#--        </div> <!-- #post-extend-wrapper &ndash;&gt;-->
        <div id="disqus_thread"></div>
        <script>

          /**
           *  RECOMMENDED CONFIGURATION VARIABLES: EDIT AND UNCOMMENT THE SECTION BELOW TO INSERT DYNAMIC VALUES FROM YOUR PLATFORM OR CMS.
           *  LEARN WHY DEFINING THESE VARIABLES IS IMPORTANT: https://disqus.com/admin/universalcode/#configuration-variables*/
          /*
          var disqus_config = function () {
          this.page.url = PAGE_URL;  // Replace PAGE_URL with your page's canonical URL variable
          this.page.identifier = PAGE_IDENTIFIER; // Replace PAGE_IDENTIFIER with your page's unique identifier variable
          };
          */
          (function() { // DON'T EDIT BELOW THIS LINE
            var d = document, s = d.createElement('script');
            s.src = 'https://blog-jaeeunyoo-com.disqus.com/embed.js';
            s.setAttribute('data-timestamp', +new Date());
            (d.head || d.body).appendChild(s);
          })();
        </script>
        <noscript>Please enable JavaScript to view the <a href="https://disqus.com/?ref_noscript">comments powered by Disqus.</a></noscript>
      </div> <!-- .col-* -->

    </div>
    <@footer.common_footer/>
  </div>
  <@trending_tags.trending_tags_m/>
</div>
<script src="//cdn.jsdelivr.net/npm/simple-jekyll-search@1.7.3/dest/simple-jekyll-search.min.js"></script>
<script src="//cdn.jsdelivr.net/combine/npm/popper.js@1.15.0,npm/bootstrap@4/dist/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/highlight.js/9.5.0/highlight.min.js"></script>
<script src="//uicdn.toast.com/editor/latest/toastui-editor-all.min.js"></script>
<script src="//uicdn.toast.com/editor-plugin-code-syntax-highlight/latest/toastui-editor-plugin-code-syntax-highlight-all.min.js"></script>
<script src="/webjars/jquery-tmpl/beta1.0.0/jquery.tmpl.min.js"></script>
<script src="/static/js/lib/post.min.js"></script>
<script src="/static/js/util/jaeeunyoo.blog.util.CommonUtil.js"></script>
<#--<script src="/static/js/util/jaeeunyoo.blog.util.SearchResultUtil.js"></script>-->
<script src="/static/js/jaeeunyoo.blog.PostView.js"></script>
<script>
  $(function () {
    // jaeeunyoo.SearchResultUtil.init();
    jaeeunyoo.blog.PostView.init({});
  });
</script>
</body>
</html>