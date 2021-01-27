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
  <link rel="preload" href="/static/css/categories.css" as="style">
  <link rel="stylesheet" href="/static/css/categories.css">
  <title>기계는 거짓말을 하지 않는다</title>
  <script src="//cdn.jsdelivr.net/npm/jquery@3/dist/jquery.min.js"></script>
</head>
<body data-spy="scroll" data-target="#toc">
<@sidebar.common_sidebar selectedMenu="CATEGORIES"/>
<@topbar.categories_topbar/>
<div id="main-wrapper">
  <div id="main">
    <div class="row">
      <div class="col-12 col-lg-11 col-xl-8">
        <div id="page" class="post pb-5 pl-1 pr-1 pl-sm-2 pr-sm-2 pl-md-4 pr-md-4 mb-md-4">
          <h1 class="dynamic-title">Categories</h1>
          <div class="post-content">
            <div class="card categories">
              <#if allCategories??>
                <#list allCategories as rootCategory>
                  <!-- Root Category -->
                  <div class="card-header d-flex justify-content-between hide-border-bottom" id="h_${rootCategory.categoryId}">
                    <span>
                      <i class="far fa-folder-open fa-fw"></i>
                      <a href="/category/${rootCategory.categoryId}" class="ml-1 mr-2">${rootCategory.categoryName}</a>
                      <span class="text-muted small font-weight-light">
                        <#if rootCategory.subCategories??>${rootCategory.subCategories?size}<#else>0</#if> categories, <#if rootCategory.posts??>${rootCategory.posts?size}<#else>0</#if> posts
                      </span>
                    </span>
                    <a href="#l_${rootCategory.categoryId}" data-toggle="collapse" aria-expanded="true" aria-label="h_${rootCategory.categoryId}-trigger" class="category-trigger hide-border-bottom">
                      <i class="fas fa-fw fa-angle-down"></i>
                    </a>
                  </div>

                  <!-- Sub Categories -->
                  <div id="l_${rootCategory.categoryId}" class="collapse show" aria-expanded="true">
                    <ul class="list-group">
                      <#if rootCategory.subCategories??>
                        <#list rootCategory.subCategories as subCategory>
                            <li class="list-group-item">
                              <i class="far fa-folder fa-fw"></i>
                              <a href="/category/${subCategory.categoryId}" class="ml-1 mr-2">${subCategory.categoryName}</a>
                              <span class="text-muted small font-weight-light"><#if subCategory.posts??>${subCategory.posts?size}<#else>0</#if> post</span>
                            </li>
                        </#list>
                      </#if>
                    </ul>
                  </div>
                </#list>
              </#if>
            </div>
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
<script src="/static/js/lib/categories.min.js"></script>
<script src="/static/js/util/jaeeunyoo.blog.util.CommonUtil.js"></script>
<#--<script src="/static/js/util/jaeeunyoo.blog.util.SearchResultUtil.js"></script>-->
<script>
  $(function () {
    // jaeeunyoo.SearchResultUtil.init();
  });
</script>
</body>
</html>