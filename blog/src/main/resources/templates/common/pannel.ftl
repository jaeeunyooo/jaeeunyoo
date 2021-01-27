<#import "trending_tags.ftl" as tag>
<#macro common_pannel displayIndex=false>
  <div id="panel-wrapper" class="col-xl-3 pl-2 text-muted topbar-down">
    <@tag.trending_tags_pc/>
    <#if displayIndex>
      <div id="toc-wrapper" class="pl-0 pr-4 mb-5 topbar-down">
        <span class="pl-3 pt-2 mb-2">Contents</span>
        <nav id="toc" data-toggle="toc"><ul class="nav navbar-nav"><li><a class="nav-link" href="#installation">Installation</a><ul class="nav navbar-nav"><li><a class="nav-link" href="#setting-up-the-local-envrionment">Setting up the local envrionment</a></li><li><a class="nav-link" href="#setting-up-docker-environment-optional">Setting up Docker environment (optional)</a></li></ul></li><li><a class="nav-link" href="#usage">Usage</a><ul class="nav navbar-nav"><li><a class="nav-link" href="#initialization">Initialization</a></li><li><a class="nav-link" href="#configuration">Configuration</a></li><li><a class="nav-link" href="#run-locally">Run Locally</a></li><li><a class="nav-link" href="#run-on-docker">Run on Docker</a></li><li><a class="nav-link" href="#deployment">Deployment</a></li></ul></li></ul></nav>
      </div>
    </#if>
  </div> <!-- #panel-wrapper -->
</#macro>