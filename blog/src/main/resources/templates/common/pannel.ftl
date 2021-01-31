<#import "trending_tags.ftl" as tag>
<#macro common_pannel displayIndex=false>
  <div id="panel-wrapper" class="col-xl-3 pl-2 text-muted topbar-down">
    <@tag.trending_tags_pc/>
    <#if displayIndex>
      <div id="toc-wrapper" class="pl-0 pr-4 mb-5 topbar-down">
        <span class="pl-3 pt-2 mb-2">Contents</span>
        <nav id="toc" data-toggle="toc">
          <ul class="nav navbar-nav">
          </ul>
        </nav>
      </div>
    </#if>
  </div> <!-- #panel-wrapper -->
</#macro>