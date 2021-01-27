<#macro common_sidebar selectedMenu="">
  <div id="sidebar" class="d-flex flex-column align-items-end">
    <div class="profile-wrapper text-center">
      <div id="avatar">
        <a href="/" alt="avatar" class="mx-auto">
          <img src="/static/img/profile.png" alt="avatar" onerror="this.style.display='none'">
        </a>
      </div>
      <div class="site-title mt-3">
        <a href="/">jaeeunyoo</a>
      </div>
      <div class="site-subtitle font-italic">기계는 거짓말을 하지 않는다</div>
    </div>
    <ul class="w-100">
      <li class="nav-item<#if selectedMenu == 'POSTS'> active</#if>">
        <a href="/" class="nav-link">
          <i class="fa-fw fas fa-home ml-xl-3 mr-xl-3 unloaded"></i>
          <span>POSTS</span>
        </a>
      </li>
      <li class="nav-item<#if selectedMenu == 'ABOUT'> active</#if>">
        <a href="/about" class="nav-link">
          <i class="fa-fw fas fa-info ml-xl-3 mr-xl-3 unloaded"></i>
          <span>ABOUT</span>
        </a>
      </li>
      <li class="nav-item<#if selectedMenu == 'CATEGORIES'> active</#if>">
        <a href="/category" class="nav-link">
          <i class="fa-fw fas fa-stream ml-xl-3 mr-xl-3 unloaded"></i>
          <span>CATEGORIES</span>
        </a>
      </li>
      <li class="nav-item<#if selectedMenu == 'TAGS'> active</#if>">
        <a href="/tag" class="nav-link">
          <i class="fa-fw fas fa-tags ml-xl-3 mr-xl-3 unloaded"></i>
          <span>TAGS</span>
        </a>
      </li>
      <li class="nav-item<#if selectedMenu == 'ARCHIVES'> active</#if>">
        <a href="/archive" class="nav-link">
          <i class="fa-fw fas fa-archive ml-xl-3 mr-xl-3 unloaded"></i>
          <span>ARCHIVES</span>
        </a>
      </li>
    </ul>
    <div class="sidebar-bottom mt-auto d-flex flex-wrap justify-content-center">
      <a href="https://github.com/jaeeunyooo" aria-label="github" class="order-3" target="_blank" rel="noopener">
        <i class="fab fa-github-alt"></i>
      </a>
      <a href="https://hub.docker.com/u/frontiersofme" aria-label="docker" class="order-4" target="_blank" rel="noopener">
        <i class="fab fa-docker"></i>
      </a>
      <a href="https://www.facebook.com/frontiersofme" aria-label="facebook" class="order-5" target="_blank" rel="noopener">
        <i class="fab fa-facebook"></i>
      </a>
      <a href="https://www.facebook.com/frontiersofme" aria-label="instagram" class="order-6" target="_blank" rel="noopener">
        <i class="fab fa-instagram"></i>
      </a>
<#--      <a href="javascript:location.href = 'mailto:' + ['frontiersofme','gmail.com'].join('@')" aria-label="email" class="order-7">-->
<#--        <i class="fas fa-envelope"></i>-->
<#--      </a>-->
<#--      <a href="/feed.xml" aria-label="rss" class="order-6">-->
<#--        <i class="fas fa-rss"></i>-->
<#--      </a>-->
      <span class="icon-border order-2"></span>
      <span id="mode-toggle-wrapper" class="order-1">
        <i class="mode-toggle fas fa-adjust"></i>
        <script src="/static/js/lib/mode-toggler.js"></script>
      </span>
    </div> <!-- .sidebar-bottom -->
  </div>
</#macro>