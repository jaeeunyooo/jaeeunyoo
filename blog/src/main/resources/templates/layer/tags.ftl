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
  <meta name="google-site-verification" content="_HplPAA2HQhu7zFsJNyzbPEojnyemv9DYCvEZqidig8" />
  <@head.cdn_jsdelivr_net/>
  <@head.cdnjs_cloudflare_com/>
  <@head.uicdn_toast_com/>
  <link rel="preload" href="/static/css/tags.css" as="style">
  <link rel="stylesheet" href="/static/css/tags.css">
  <title>기계는 거짓말을 하지 않는다</title>
  <script src="//cdn.jsdelivr.net/npm/jquery@3/dist/jquery.min.js"></script>
</head>
<body data-spy="scroll" data-target="#toc">
<@sidebar.common_sidebar selectedMenu="TAGS"/>
<@topbar.tags_topbar/>
<div id="main-wrapper">
  <div id="main">
    <div class="row">
      <div class="col-12 col-lg-11 col-xl-8">
        <div id="page" class="post pb-5 pl-1 pr-1 pl-sm-2 pr-sm-2 pl-md-4 pr-md-4 mb-md-4">
          <h1 class="dynamic-title">Tags</h1>
          <div class="post-content">
            <div id="tags" class="d-flex flex-wrap ml-xl-2 mr-xl-2">
              <#if tags??>
                <#list tags as tag>
                  <div>
                    <a class="tag" href="/tag/${tag.tagId}">${tag.tagName}<span class="text-muted">${tag.taggedPosts?size}</span></a>
                  </div>
                </#list>
              </#if>
            </div>
          </div>
        </div> <!-- #page -->
      </div>
      <@pannel.common_pannel false/>
    </div>
    <@footer.common_footer/>
  </div>
    <@trending_tags.trending_tags_m/>
</div>
<script src="//cdn.jsdelivr.net/npm/simple-jekyll-search@1.7.3/dest/simple-jekyll-search.min.js"></script>
<script src="//cdn.jsdelivr.net/combine/npm/popper.js@1.15.0,npm/bootstrap@4/dist/js/bootstrap.min.js"></script>
<script src="/webjars/jquery-tmpl/beta1.0.0/jquery.tmpl.min.js"></script>
<script src="/static/js/lib/post.min.js"></script>
<script src="/static/js/util/jaeeunyoo.blog.util.CommonUtil.js"></script>
<#--<script src="/static/js/util/jaeeunyoo.blog.util.SearchResultUtil.js"></script>-->
<script>
  $(function () {
    // jaeeunyoo.SearchResultUtil.init();
  });
</script>
</body>
</html>