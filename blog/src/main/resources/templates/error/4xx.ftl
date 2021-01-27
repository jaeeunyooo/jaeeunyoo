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
<@sidebar.common_sidebar selectedMenu=""/>
<@topbar.error_topbar/>
<div id="main-wrapper">
  <div id="main">
    <div class="row">
      <div class="col-12 col-lg-11 col-xl-8">
        <div id="page" class="post pb-5 pl-1 pr-1 pl-sm-2 pr-sm-2 pl-md-4 pr-md-4 mb-md-4">
          <#if httpStatus?? && httpStatus == 403>
            <h1 class="dynamic-title">권한이 없습니다</h1>
            <div class="post-content">
<#--              <div class="lead">-->
<#--                <p>Sorry, we've misplaced that URL or it's pointing to something that doesn't exist. </p>-->
<#--                <p><a href="/">Head back Home</a> to try finding it again, or search for it on the <a href="/tabs/archives">Archives page</a>.</p>-->
<#--              </div>-->
            </div>
          </#if>
          <#if httpStatus?? && httpStatus == 404>
            <h1 class="dynamic-title">페이지를 찾을 수 없습니다.</h1>
            <div class="post-content">
<#--              <div class="lead">-->
<#--                <p>Sorry, we've misplaced that URL or it's pointing to something that doesn't exist. </p>-->
<#--                <p><a href="/">Head back Home</a> to try finding it again, or search for it on the <a href="/tabs/archives">Archives page</a>.</p>-->
<#--              </div>-->
            </div>
          </#if>
        </div> <!-- #page -->
      </div><!-- .col-12 -->
      <@pannel.common_pannel false/>
    </div>
    <@footer.common_footer/>
  </div>
  <@trending_tags.trending_tags_m/>
</div> <!-- #main-wrapper -->
<div id="mask"></div>
<a id="back-to-top" href="#" aria-label="back-to-top" class="btn btn-lg btn-box-shadow" role="button">
  <i class="fas fa-angle-up"></i>
</a>

<script src="//cdn.jsdelivr.net/npm/simple-jekyll-search@1.7.3/dest/simple-jekyll-search.min.js"></script>
<script src="//cdn.jsdelivr.net/combine/npm/popper.js@1.15.0,npm/bootstrap@4/dist/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/highlight.js/9.5.0/highlight.min.js"></script>
<script src="//uicdn.toast.com/editor/latest/toastui-editor-all.min.js"></script>
<script src="//uicdn.toast.com/editor-plugin-code-syntax-highlight/latest/toastui-editor-plugin-code-syntax-highlight-all.min.js"></script>
<script src="/webjars/jquery-tmpl/beta1.0.0/jquery.tmpl.min.js"></script>
<script src="/static/js/lib/post.min.js"></script>
<script src="/static/js/util/jaeeunyoo.blog.util.CommonUtil.js"></script>
<#--<script src="/static/js/util/jaeeunyoo.blog.util.SearchResultUtil.js"></script>-->
<script>
  $(function () {});
</script>
</body>
</html>

