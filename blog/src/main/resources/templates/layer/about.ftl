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
<@sidebar.common_sidebar selectedMenu="ABOUT"/>
<@topbar.about_topbar/>
<div id="main-wrapper">
  <div id="main">
    <div class="row">
      <div id="post-wrapper" class="col-12 col-lg-11 col-xl-8">
        <div class="post pl-1 pr-1 pl-sm-2 pr-sm-2 pl-md-4 pr-md-4">
          <h1 data-toc-skip=""><em>기계는 거짓말을 하지 않는다</em></h1>
          <div id="_postContent" class="post-content">
            <h3>About Me</h3>
            <ul>
              <li>보통의 개발자</li>
              <li>퇴근 후 토이 프로젝트 즐기는 편</li>
              <li>낚시와 캠핑 매우 좋아함</li>
            </ul>
          </div>
        </div> <!-- .post -->
      </div> <!-- #post-wrapper -->
      <@pannel.common_pannel false/>
    </div>
    <div class="row">
      <@footer.common_footer/>
    </div>
    <@trending_tags.trending_tags_m/>
  </div>
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
<script>
  $(function () {
    // jaeeunyoo.SearchResultUtil.init();
  });
</script>
</body>
</html>