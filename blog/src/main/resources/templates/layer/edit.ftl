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
  <style>
    .te-md-container .te-preview {
      background-color: white;
    }
  </style>
  <title>기계는 거짓말을 하지 않는다</title>
  <script src="//cdn.jsdelivr.net/npm/jquery@3/dist/jquery.min.js"></script>
</head>
<body data-spy="scroll" data-target="#toc">
<@sidebar.common_sidebar selectedMenu="POSTS"/>
<@topbar.edit_topbar/>
<div id="main-wrapper">
  <div id="main">
    <div class="row" style="height: 120px;">
      <div id="post-wrapper" class="col-lg-11" style="padding-top:20px">
        <h1>Edit Post</h1>
        <span>Category</span>
        <div>
          <#if allCategories??>
            <select id="_select_root_category" name="category">
              <#list allCategories as rootCategory>
                <#if post??>
                  <#if post.upperCategoryId == 0>
                    <option value="${rootCategory.categoryId?c}" <#if (post.categoryId?c == rootCategory.categoryId?c)>selected</#if>>${rootCategory.categoryName}</option>
                  <#else>
                    <option value="${rootCategory.categoryId?c}" <#if (post.upperCategoryId?c == rootCategory.categoryId?c)>selected</#if>>${rootCategory.categoryName}</option>
                  </#if>
                <#else>
                  <option value="${rootCategory.categoryId?c}">${rootCategory.categoryName}</option>
                </#if>
              </#list>
            </select>
          </#if>
          <#if allCategories??>
            <#list allCategories as rootCategory>
              <#if post??>
                <div id="_sub_category_${rootCategory.categoryId?c}" class="_sub_category" <#if post.upperCategoryId?c == rootCategory.categoryId?c>style="display: inline"<#else>style="display: none"</#if>>
              <#else>
                <div id="_sub_category_${rootCategory.categoryId?c}" class="_sub_category" style="display: none">
              </#if>
                <select id="_select_sub_category_${rootCategory.categoryId?c}" name="category">
                  <option value="">NONE</option>
                  <#list rootCategory.subCategories as subCategory>
                    <option value="${subCategory.categoryId?c}" <#if (post?? && post.upperCategoryId != 0 && post.categoryId?c == subCategory.categoryId?c)>selected</#if>>${subCategory.categoryName}</option>
                  </#list>
                </select>
              </div>
            </#list>
          </#if>
        </div>
        <div>
          <#if post??>
            <div>
              <span>Title</span>
              <input type="text" autocomplete="false" placeholder="제목을 입력해 주세요." maxlength="300" id="postTitle" style="width: 100%" value="${post.postTitle}" />
            </div>
            <div>
              <span>Tags</span>
              <input type="text" autocomplete="false" placeholder="태그를 입력하세요." maxlength="300" id="tags" style="width: 100%" value="${post.tags}"/>
            </div>
          <#else>
            <div>
              <span>Title</span>
              <input type="text" autocomplete="false" placeholder="제목을 입력하세요." maxlength="300" id="postTitle" style="width: 100%" value="" />
            </div>
            <div>
              <span>Tags</span>
              <input type="text" autocomplete="false" placeholder="태그를 입력하세요." maxlength="300" id="tags" style="width: 100%" value="" />
            </div>
          </#if>
        </div>
        <span>Content</span>
        <div id="_editor">
          <#if post??>${post.postContentHtml}</#if>
        </div>
        <button id="saveAndResume" type="button">저장 후 계속</button>
        <button id="save" type="button">저장</button>
      </div>
    </div>
  </div>
  <@trending_tags.trending_tags_m/>
</div>
<script src="//cdn.jsdelivr.net/npm/simple-jekyll-search@1.7.3/dest/simple-jekyll-search.min.js"></script>
<script src="//cdn.jsdelivr.net/combine/npm/popper.js@1.15.0,npm/bootstrap@4/dist/js/bootstrap.min.js"></script>
<script src="https://uicdn.toast.com/editor/latest/toastui-editor-all.min.js"></script>
<script src="https://uicdn.toast.com/editor-plugin-color-syntax/latest/toastui-editor-plugin-color-syntax.min.js"></script>
<script src="https://uicdn.toast.com/editor-plugin-code-syntax-highlight/latest/toastui-editor-plugin-code-syntax-highlight-all.min.js"></script>
<script src="https://uicdn.toast.com/editor-plugin-chart/latest/toastui-editor-plugin-chart.min.js"></script>
<script src="https://uicdn.toast.com/editor-plugin-table-merged-cell/latest/toastui-editor-plugin-table-merged-cell.min.js"></script>
<script src="https://uicdn.toast.com/editor-plugin-uml/latest/toastui-editor-plugin-uml.min.js"></script>
<script src="/static/js/lib/post.min.js"></script>
<script src="/static/js/util/jaeeunyoo.blog.util.CommonUtil.js"></script>
<script src="/static/js/jaeeunyoo.blog.EditView.js"></script>
<script>
  $(function () {
    jaeeunyoo.blog.EditView.init({<#if post??>postId: ${post.postId?c}</#if>});
  });
</script>
</body>
</html>