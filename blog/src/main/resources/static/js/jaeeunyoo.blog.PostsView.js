jaeeunyoo.CommonUtil.createNamespace("jaeeunyoo.blog.PostsView");

jaeeunyoo.blog.PostsView = (function () {

  "use strict";

  let _htOption, _htEle;

  function _init(htOption) {
    _htOption = htOption || {};
    _initVar();
    _initElement();
    _initEvent();
    return this;
  }

  function _initVar() {
    _htOption.page = 0;
  }

  function _initElement () {
    _htEle = {
      postListItemTemplate: $("#_postListItemTemplate"),
      postListArea: $("#post-list"),
      paginationTemplate: $("#_paginationTemplate"),
      paginationArea: $(".pagination"),
      pageLink: $(".page-link")
    };
  }

  function _initEvent () {
    onClickPageLink();
  }


  function onClickPageLink() {
    _htEle.paginationArea.on('click', 'a', function () {
      let th = $(this);
      let pageNumber = th.data("pagenumber");
      if(pageNumber === _htOption.page) {
        return;
      }

      jaeeunyoo.CommonUtil.callAjax({
        url: "/api/post/recent",
        cache: false,

        param: {page: pageNumber},
        success: function (data) {
          _htOption.page = pageNumber;
          _initPostPage(data);
          _initPagination(data);
        },
        error: function (data) {
        }
      });
    });
  }

  function _initPostPage (data) {
    _htEle.postListArea.empty();
    _htEle.postListItemTemplate.tmpl(data.content).appendTo(_htEle.postListArea);
  }

  function _initPagination (data) {
    _htEle.paginationArea.empty();
    data.pageRange = [];

    let i = parseInt(data.number / 10);
    i = i * 10;
    data.previousPageNumber = i < 1 ? 0 : i - 1;

    let maxPageNumber;
    if(i + 9 < data.totalPages - 1) {
      maxPageNumber = i + 9;
      data.nextPageNumber = maxPageNumber + 1;
    } else {
      maxPageNumber = data.totalPages - 1;
      data.nextPageNumber = maxPageNumber;
    }

    for(; i <= maxPageNumber; i++) {
      data.pageRange.push(i);
    }

    _htEle.paginationTemplate.tmpl(data).appendTo(_htEle.paginationArea);
  }

  return {
    init: _init
  }
})();