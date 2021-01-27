"use strict";
var jaeeunyoo = (typeof jaeeunyoo !== "undefined") ? jaeeunyoo : {};

jaeeunyoo.SearchResultUtil = {
  init: function () {
    jaeeunyoo.CommonUtil.callAjax({
      url: "/api/post/all",
      cache: false,
      success: function (data) {
        jaeeunyoo.SearchResultUtil.draw(data);
      },
      error: function (data) {
      }
    });
  },

  draw: function (data) {
    SimpleJekyllSearch({
      searchInput: document.getElementById('search-input'),
      resultsContainer: document.getElementById('search-results'),
      json: data,
      searchResultTemplate: '\
            <div class="pl-1 pr-1 pl-sm-2 pr-sm-2 pl-lg-4 pr-lg-4 pl-xl-0 pr-xl-0">\
              <a href="{url}">{title}</a>\
              <div class="post-meta d-flex flex-column flex-sm-row text-muted mt-1 mb-1">\
                <div class="mr-sm-4"><i class="far fa-folder fa-fw"></i>{categories}</div>\
                <div><i class="fa fa-tag fa-fw"></i>{tags}</div>\
              </div>\
              <p>{snippet}</p>\
            </div>',
      noResultsText: '<p class="mt-5">Oops! No result founds.</p>'
    });
  }
};