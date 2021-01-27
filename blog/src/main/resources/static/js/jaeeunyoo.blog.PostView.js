jaeeunyoo.CommonUtil.createNamespace("jaeeunyoo.blog.PostView");

jaeeunyoo.blog.PostView = (function () {

  "use strict";

  let _htOption, _htEle;

  function _init(htOption) {
    _htOption = htOption || {};
    hljs.initHighlightingOnLoad();
    return this;
  }

  return {
    init: _init
  }
})();