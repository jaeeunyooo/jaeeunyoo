jaeeunyoo.CommonUtil.createNamespace("jaeeunyoo.blog.EditView");

jaeeunyoo.blog.EditView = (function () {

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
  }

  function _initElement () {
    _htEle = {};
    _htEle.selectRootCategory = $('#_select_root_category');
    _htEle.saveAndResume = $('#saveAndResume');
    _htEle.save = $('#save');
    const { Editor } = toastui;
    const { chart, codeSyntaxHighlight, colorSyntax, tableMergedCell, uml } = Editor.plugin;
    _htEle.editor = new Editor({
      el: document.querySelector('#_editor'),
      previewStyle: 'vertical',
      height: '900px',
      viewer: true,
      // plugins: [[codeSyntaxHighlight, colorSyntax, chart, tableMergedCell, uml]],
      plugins: [[chart], codeSyntaxHighlight, colorSyntax, tableMergedCell, uml],
      hooks: {
        'addImageBlobHook': function(blob, callback) {
          var formData = new FormData();
          formData.append("imageFile", blob);
          $.ajax({
            type: "POST",
            enctype: 'multipart/form-data',
            url: "/api/image",
            data: formData,
            processData: false,
            contentType: false,
            cache: false,
            success: function (toastImage) {
              if(toastImage != null) {
                console.log("SUCCESS");
                callback(toastImage.url, 'image');
              }
            },
            error: function (toastImage) {
              console.log("ERROR");
            }
          });
        }
      }
    });
  }

  function _initEvent() {
    _htEle.selectRootCategory.on('change', function () {
      let th = $(this);
      let rootCategoryId = th.val();
      $('._sub_category').css('display', 'none');
      $('#_sub_category_' + rootCategoryId).css('display', 'inline');
    });

    _htEle.saveAndResume.on('click', function () {
      _savePost(_getParam(), function (data) {
        if(data) {
          _htOption.postId = data;
          alert("saved");
        }
      });
    });

    _htEle.save.on('click', function () {
      _savePost(_getParam(), function (data) {
        if(data) {
          _htOption.postId = data;
          location.href = "/post/" + data;
        }
      });
    });
  }

  function _getParam() {
    let tags = $('#tags').val().toUpperCase().split(",");
    if(tags.length === 1 && tags[0] === "")
      tags = [];

    let param = {};
    param.postId = _htOption.postId;
    param.tags = tags;
    param.postTitle = $('#postTitle').val();
    param.postContentHtml = _htEle.editor.getHtml();

    let rootCategoryId = $('#_select_root_category').val();
    let subCategoryId = null;
    if(rootCategoryId) {
      subCategoryId = $('#_select_sub_category_' + rootCategoryId).val();
    }

    if(subCategoryId) {
      param.categoryId = parseInt(subCategoryId);
    } else {
      param.categoryId = parseInt(rootCategoryId);
    }

    return param;
  }

  function _savePost (param, callback) {
    $.ajax({
      url: "/api/post",
      cache: false,
      contentType: 'application/json',
      data: JSON.stringify(param),
      success: callback,
      error: function (data) {
        console.log(data);
      },
      type: param.postId === undefined ? "POST" : "PUT",
      dateType: "json"
    });
  }

  return {
    init: _init
  }
})();