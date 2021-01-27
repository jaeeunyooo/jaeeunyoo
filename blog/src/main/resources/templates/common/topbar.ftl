<#macro _search_layer>
  <div id="topbar-wrapper" class="row justify-content-center topbar-down">
    <div id="topbar" class="col-11 d-flex h-100 align-items-center justify-content-between">
      <#nested>
      <i id="sidebar-trigger" class="fas fa-bars fa-fw"></i>
      <a href="/sign-in" class="nav-link" style="display: contents"><i class="fa-fw fas fa-sign-in-alt ml-xl-3 mr-xl-3"></i></a>
<#--      <div id="topbar-title">Tags</div>-->
<#--      <i id="search-trigger" class="fas fa-search fa-fw"></i>-->
<#--      <span id="search-wrapper" class="align-items-center">-->
<#--        <i class="fas fa-search fa-fw"></i>-->
<#--        <input class="form-control" id="search-input" type="search" aria-label="search" placeholder="Search...">-->
<#--        <i class="fa fa-times-circle fa-fw" id="search-cleaner"></i>-->
<#--      </span>-->
<#--      <span id="search-cancel">Cancel</span>-->
    </div>
  </div>
</#macro>

<#macro posts_topbar>
  <@_search_layer>
    <span id="breadcrumb">
      <span>Post</span>
    </span>
  </@_search_layer>
</#macro>

<#macro post_topbar>
  <@_search_layer>
    <span id="breadcrumb">
      <span>
        <a href="/">Post</a>
      </span>
      <span>${post.postTitle}</span>
    </span>
  </@_search_layer>
</#macro>

<#macro edit_topbar>
  <@_search_layer>
    <span id="breadcrumb">
      <span>Edit</span>
    </span>
  </@_search_layer>
</#macro>

<#macro categories_topbar>
  <@_search_layer>
    <span id="breadcrumb">
      <span>
        <a href="/">Home</a>
      </span>
      <span>Categories</span>
    </span>
  </@_search_layer>
</#macro>

<#macro category_topbar>
  <@_search_layer>
    <span id="breadcrumb">
      <span>
        <a href="/">Home</a>
      </span>
      <span>
        <a href="/category">Categories</a>
      </span>
      <span>${category.categoryName}</span>
    </span>
  </@_search_layer>
</#macro>

<#macro tags_topbar>
    <@_search_layer>
      <span id="breadcrumb">
      <span>
        <a href="/">Home</a>
      </span>
      <span>Tags</span>
    </span>
    </@_search_layer>
</#macro>

<#macro tag_topbar>
  <@_search_layer>
    <span id="breadcrumb">
      <span>
        <a href="/">Home</a>
      </span>
      <span>
        <a href="/tag">Tags</a>
      </span>
      <span>${tag}</span>
    </span>
  </@_search_layer>
</#macro>

<#macro archive_topbar>
    <@_search_layer>
      <span id="breadcrumb">
      <span>
        <a href="/">Home</a>
      </span>
      <span>Archives</span>
    </span>
    </@_search_layer>
</#macro>

<#macro about_topbar>
    <@_search_layer>
    <span id="breadcrumb">
      <span>
        <a href="/">Home</a>
      </span>
      <span>About</span>
    </span>
    </@_search_layer>
</#macro>

<#macro error_topbar>
    <@_search_layer>
    <span id="breadcrumb">
      <span>Error</span>
    </span>
    </@_search_layer>
</#macro>