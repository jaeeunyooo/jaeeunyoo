"use strict";
var jaeeunyoo = (typeof jaeeunyoo !== "undefined") ? jaeeunyoo : {};

jaeeunyoo.CommonUtil = {
  /**
   * @description 문자열로부터 네임스페이스를 생성하는 함수
   * @param {String} sNamespace 네임스페이스 문자열 (예: payco.Component)
   * @return {Object}
   */
  createNamespace: function (sNamespace) {
    var aSpace = sNamespace.split(".");
    var oParent = window;
    var sObjectName = null;
    for (var i = 0, len = aSpace.length; i < len; i++) {
      sObjectName = aSpace[i];
      if (i == (len - 1)) {
        break;
      }
      if (typeof oParent[sObjectName] !== "object") {
        oParent[sObjectName] = {};
      }
      oParent = oParent[sObjectName];
    }
    return {
      container: oParent,
      name: sObjectName
    };
  },

  /**
   * @description 세자리마다 자릿수 표시
   * @param {number} x : 입력값
   */
  numWithCommas: function (n) {
    return n.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
  },

  /**
   * @description 문자열내에 공백 유무 체크
   * @param 문자열
   */
  isEmptyInString: function (s) {
    return (s.search(/\s/) > -1);
  },

  /**
   * @description 공백문자체크
   * @param 문자열
   */
  isEmpty: function (s) {
    var sTrim = ((s == undefined) ? "" : $.trim(s));
    return (sTrim == "");
  },

  /**
   * @description 한자리 숫자 두자리로 변환
   * @param 숫자
   */
  getTwoByteNum: function (nNum) {
    return (parseInt(nNum, 10) < 10) ? "0" + nNum : nNum;
  },

  /**
   * 펑션키 여부
   * backspace, tab, shift, capslock, 한/영, end, home, 방향키, insert, delete, scrolllock, pause, f1 ~ f12
   * @param keyCode
   * @returns {Boolean}
   */
  isFuncKey: function (keyCode) {
    var aKey = [8, 9, 16, 17, 19, 20, 27, 33, 34, 35, 36, 37, 38, 39, 40, 45,
      46, 91, 111, 112, 113, 114, 115, 117, 118, 119, 120, 121, 122, 123, 144,
      145];
    return (aKey.indexOf(keyCode) > -1);
  },

  /**
   *요일
   */
  getDayOfWeek: function (s) {
    var aName = ["일", "월", "화", "수", "목", "금", "토"];
    var nIdx = new Date(s).getDay();
    return aName[nIdx];
  },

  /**
   * form 전송용
   * @param htOption
   */
  submitForm: function (ht) {
    var elForm = $("<form method=''></form>");
    for (var key in ht.param) {
      var elHidden = $("<input type='hidden' name='" + key + "' value='"
          + ht.param[key] + "'>");
      elForm.append(elHidden);
    }
    elForm.attr("method", ht.method)
    .attr("target", ht.name)
    .attr("action", ht.action);
    if (ht.enctype != undefined) {
      elForm.attr("enctype", "multipart/form-data");
    }
    $("body").append(elForm);
    elForm.submit();
  },

  /**
   * Ajax 공통
   * @param htParam
   */
  callAjax: function (htParam) {
    var funcError = (htParam.error === undefined) ? this.ajaxError : htParam.error;
    var oReOpt = (htParam.reOption === undefined) ? {} : htParam.reOption;
    var cacheOpt = (htParam.cache === undefined) ? true : htParam.cache;
    var asynOpt = (htParam.async === undefined) ? true : htParam.async;
    $.ajax({
      url: htParam.url,
      success: function (res) {
        htParam.success(res, oReOpt);
      },
      error: funcError,
      cache: cacheOpt,
      type: htParam.type,
      data: htParam.param,
      async: asynOpt
    });
  },

  /**
   * @desc 파일 upload
   * @param htParam
   */
  uploadImage: function (htParam) {
    var fileData = $('#' + htParam.fileId).prop('files')[0];
    var elFormData = new FormData();
    elFormData.append("imagefile", fileData);

    $.ajax({
      url: htParam.url,
      type: 'post',
      data: elFormData,
      cache: false,
      contentType: false,
      processData: false,
      success: htParam.callBack
    });
  },

  /**
   * Ajax 에러 발생시 콜백
   * @param err
   */
  ajaxError: function (err) {
    console.log("Ajax 호출 에러 : " + err.toString());
    ;
  },

  /**
   * @desc millisecond 를 정해진 포멧으로 포멧팅
   * @param n
   * @param sFormat
   * @returns {XML|string}
   */
  getFormatDate: function (n, sFormat) {
    var nMillSec = parseInt(n, 10);
    var oDate = new Date(nMillSec);
    var sDate = sFormat.replace(/Y/ig, oDate.getFullYear())
    .replace(/M/ig, this.getTwoByteNum(oDate.getMonth() + 1))
    .replace(/m/ig, (oDate.getMonth() + 1))
    .replace(/D/ig, this.getTwoByteNum(oDate.getDate()))
    .replace(/H/ig, oDate.getHours())
    .replace(/i/ig, this.getTwoByteNum(oDate.getMinutes()))
    .replace(/s/ig, oDate.getSeconds());
    return sDate;
  },

  getAbsoluteUrl: function (sUrl) {
    return 'http://{url}'.replace(/{url}/ig, sUrl.replace('https://', '').replace('http://', ''));
  },

  getProtocolessUrl: function (sUrl) {
    return sUrl.replace('https://', '').replace('http://', '');
  },

  escapeHtml: function (unsafe) {
    return $('<div />').text(unsafe).html();
  },

  unescapeHtml: function (safe) {
    return $('<div />').html(safe).text();
  },

  postJson: function (url, object, callback, errorback) {
    var options = {
      "url": url,
      "contentType": 'application/json',
      "param": JSON.stringify(object),
      "cache": false,
      "success": callback,
      "error": errorback,
      "type": "POST",
      "dateType": "json"
    };
    this.callAjax(options);
  },

  /**
   * Ajax PUT( JSON BODY ) 공통
   * @param url
   * @param object
   * @param callback
   * @param errorback
   */
  putJson: function (url, object, callback, errorback) {
    var options = {
      "url": url,
      "contentType": 'application/json',
      "param": JSON.stringify(object),
      "cache": false,
      "success": callback,
      "error": errorback,
      "type": "PUT",
      "dateType": "json"
    };
    this.callAjax(options);
  },

  /**
   * Ajax GET(QueryString only) 공통
   * @param url
   * @param callback
   * @param errorback
   */
  get: function (url, callback, errorback) {
    var options = {
      "url": url,
      "cache": false,
      "success": callback,
      "error": errorback,
      "type": "GET"
    };
    this.callAjax(options);
  },

  /**
   * Ajax GET(QueryString only) 공통
   * @param url
   * @param callback
   * @param errorback
   */
  deleteAjax: function (url, callback, errorback) {
    var options = {
      "url": url,
      "cache": false,
      "success": callback,
      "error": errorback,
      "type": "DELETE"
    };
    this.callAjax(options);
  }
};