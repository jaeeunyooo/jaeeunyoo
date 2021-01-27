<#macro trending_tags_pc>
  <div class="access">
    <div id="access-tags">
      <span>Trending Tags</span>
      <div class="d-flex flex-wrap mt-3 mb-1 mr-3">
        <#if trendingTags??>
          <#list trendingTags as tag>
            <a class="post-tag" href="/tag/${tag.tagId}">${tag.tagName}</a>
          </#list>
        </#if>
      </div>
    </div>
  </div>
</#macro>

<#macro trending_tags_m>
  <div id="search-result-wrapper" class="d-flex justify-content-center unloaded">
    <div class="col-12 col-xl-11 post-content">
      <div id="search-hints">
        <h4 class="text-muted mb-4">Trending Tags</h4>
        <#if trendingTags??>
            <#list trendingTags as tag>
              <a class="post-tag" href="/tag/${tag.tagId}">${tag.tagName}</a>
            </#list>
        </#if>
      </div>
      <div id="search-results" class="d-flex flex-wrap justify-content-center text-muted mt-3"></div>
    </div>
  </div>
  <div id="mask"></div>
  <a id="back-to-top" href="#" aria-label="back-to-top" class="btn btn-lg btn-box-shadow" role="button">
    <i class="fas fa-angle-up"></i>
  </a>
</#macro>