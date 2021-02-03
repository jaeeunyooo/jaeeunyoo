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
  <link rel="preload" href="/static/css/post.css" as="style">
  <link rel="stylesheet" href="/static/css/post.css">
  <link rel="stylesheet" href="/static/css/lib/androidstudio.min.css">
  <title>기계는 거짓말을 하지 않는다</title>
  <script src="https://cdn.jsdelivr.net/npm/jquery@3/dist/jquery.min.js"></script>
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
          <div id="_aboutContent">
            <h2>About Me</h2>
            <p><img src="http://image.toast.com/aaaabai/jaeeunyoo/blog/401e257f-bd65-4e5b-8ea6-2cae4c75632e.png" alt="image"></p>
            <ul>
              <li>89년 4월 1일 거짓말처럼 태어남</li>
              <li>보통의 서버 개발자</li>
              <li>회사 프로젝트하다가 퇴근하고 토이 프로젝트 즐기는 편</li>
              <li>관심 분야
                <ul>
                  <li>백엔드, 인프라, 임베디드</li>
                  <li>Java, Kotlin, Python</li>
                  <li>낚시, 캠핑</li>
                  <li>먹고 살 궁리</li>
                </ul>
              </li>
            </ul>
            <h2>About Blog</h2>
            <ul>
              <li>블로그 프로젝트 : <a href="https://github.com/jaeeunyooo/jaeeunyoo">https://github.com/jaeeunyooo/jaeeunyoo</a></li>
              <li>본 블로그는 Nginx, SpringBoot, JPA, MySQL, Redis, Toast UI Editor, Toast Image 등을 이용하여 만들어졌습니다</li>
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
<script src="https://cdn.jsdelivr.net/npm/simple-jekyll-search@1.7.3/dest/simple-jekyll-search.min.js"></script>
<script src="https://cdn.jsdelivr.net/combine/npm/popper.js@1.15.0,npm/bootstrap@4/dist/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/9.5.0/highlight.min.js"></script>
<script src="https://uicdn.toast.com/editor/latest/toastui-editor-all.min.js"></script>
<script src="https://uicdn.toast.com/editor-plugin-code-syntax-highlight/latest/toastui-editor-plugin-code-syntax-highlight-all.min.js"></script>
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