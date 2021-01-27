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
  <link rel="preload" href="/static/css/category-tag.css" as="style">
  <link rel="stylesheet" href="/static/css/category-tag.css">
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
          <div id="page-tag">
            <h1 class="pl-lg-2">
              <i class="fa fa-tag fa-fw text-muted"></i>
              ${tag.tagName}
              <span class="lead text-muted pl-2">${tag.postTags?size}</span>
            </h1>
            <ul class="post-content pl-0">
              <#if taggedPosts??>
                <#list taggedPosts as post>
                  <li class="d-flex justify-content-between pl-md-3 pr-md-3">
                    <a href="/post/${post.postId}">${post.postTitle}</a>
                    <span class="dash flex-grow-1"></span>
                    <span class="text-muted small">${post.formattedModifyDate}</span>
                  </li>
                </#list>
              </#if>
            </ul>
          </div>
        </div>
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
<script src="/static/js/lib/page.min.js"></script>
<script src="/static/js/util/jaeeunyoo.blog.util.CommonUtil.js"></script>
<#--<script src="/static/js/util/jaeeunyoo.blog.util.SearchResultUtil.js"></script>-->
<script>
  $(function () {
    // jaeeunyoo.SearchResultUtil.init();
  });
</script>
</body>
</html>