(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-265fd907"],{"15d5":function(t,i,s){},"1e4b":function(t,i,s){"use strict";s.r(i);var e=function(){var t=this,i=t.$createElement,e=t._self._c||i;return e("div",{attrs:{id:"index"}},[e("div",{style:t.sizeInfo,attrs:{id:"topBar"}},[e("div",{staticClass:"logoImg"}),e("div",{attrs:{id:"nav"}},[e("div",{staticClass:"dropdown"},[e("router-link",{attrs:{to:"/index/intro"}},[t._v("首页")])],1),e("div",{staticClass:"dropdown"},[e("router-link",{attrs:{to:"/index/products"}},[t._v("产品中心")]),e("div",{staticClass:"navList"},[e("div",{staticClass:"item"},[e("router-link",{attrs:{to:"/index/products/C9pro"}},[t._v("C9pro飞行控制器")])],1),e("div",{staticClass:"item"},[e("router-link",{attrs:{to:"/index/products/C9"}},[t._v("C9飞行控制器")])],1),e("div",{staticClass:"item"},[e("router-link",{attrs:{to:"/index/products/A9"}},[t._v("A9飞行控制器")])],1),e("div",{staticClass:"item"},[e("router-link",{attrs:{to:"/index/products/mapping"}},[t._v("整机解决方案")])],1)])],1),e("div",{staticClass:"dropdown"},[e("router-link",{attrs:{to:"/index/cases"}},[t._v("应用案例")])],1),e("div",{staticClass:"dropdown"},[e("router-link",{attrs:{to:"/index/skill",target:"_blank"}},[t._v("技术支持")]),e("div",{staticClass:"navList"},[e("div",{staticClass:"item"},[e("p",{staticStyle:{color:"black"},on:{click:function(i){return t.downloadZip()}}},[t._v("地面站下载")])]),e("div",{staticClass:"item"},[e("router-link",{attrs:{to:"/index/skill",target:"_blank"}},[t._v("技术文档")])],1),e("div",{staticClass:"item"},[e("router-link",{attrs:{to:"/index/develop"}},[t._v("定制开发")])],1),e("div",{staticClass:"item"},[e("router-link",{attrs:{to:"/index/problem"}},[t._v("常见问题")])],1)])],1)]),e("div",{attrs:{id:"switchBtn"}},[t._v("简体中文")])]),e("router-view",{staticClass:"content",style:t.sizeInfo}),e("div",{style:t.sizeInfo,attrs:{id:"footer"}},[e("div",{staticClass:"footerContent"},[t._m(0),e("div",{staticClass:"footerList"},[e("p",{staticClass:"title"},[t._v("热门产品")]),e("router-link",{attrs:{to:"/index/products/C9pro"}},[t._v("C9 PRO飞行控制器")]),e("router-link",{attrs:{to:"/index/products/C9"}},[t._v("C9 飞行控制器")]),e("router-link",{attrs:{to:"/index/products/A9"}},[t._v("A9 飞行控制器")]),e("router-link",{attrs:{to:"/index/products/mapping"}},[t._v("整机解决方案")])],1),e("div",{staticClass:"footerList"},[e("p",{staticClass:"title"},[t._v("购买渠道")]),e("router-link",{attrs:{to:"/index/pay",target:"_blank"}},[t._v("立即购买")]),e("router-link",{attrs:{to:"/index/develop"}},[t._v("经销合作")]),e("p",{staticStyle:{"font-size":"18px",color:"rgba(255,255,255,0.4)"},on:{click:function(i){return t.downloadZip()}}},[t._v("地面站下载")])],1),e("div",{staticClass:"footerList"},[e("p",{staticClass:"title"},[t._v("安全飞行")]),e("router-link",{attrs:{to:"/index/safe"}},[t._v("安全飞行指引")])],1),e("div",{staticClass:"footerList"},[e("p",{staticClass:"title"},[t._v("联系我们")]),e("el-popover",{attrs:{placement:"top-start",effect:"dark",width:"150",trigger:"hover"}},[e("img",{attrs:{src:s("6260"),alt:"企业微信"}}),e("a",{attrs:{slot:"reference",href:"#",onclick:"return false"},slot:"reference"},[t._v("企业微信")])]),e("el-popover",{attrs:{placement:"top-start",width:"150",trigger:"hover"}},[e("img",{attrs:{src:s("8b52"),alt:"企业微信"}}),e("a",{attrs:{slot:"reference",href:"#",onclick:"return false"},slot:"reference"},[t._v("微信公众号")])]),e("router-link",{attrs:{to:"/index/company"}},[t._v("关于我们")])],1)]),t._m(1)])],1)},o=[function(){var t=this,i=t.$createElement,e=t._self._c||i;return e("div",{staticClass:"logoImg"},[e("img",{staticClass:"logo",attrs:{src:s("9d64"),alt:"博睿创新科技"}})])},function(){var t=this,i=t.$createElement,e=t._self._c||i;return e("div",{staticClass:"copy"},[e("div",{staticClass:"line"}),e("div",{staticClass:"copyContent"},[e("div",{staticClass:"logoImg"},[e("img",{staticClass:"logo",attrs:{src:s("9d64"),alt:"博睿创新科技"}})]),e("p",{staticClass:"copyRight"},[t._v("IC备案：粤ICP备2020124827号 广州博睿创新科技有限公司")])])])}],r={name:"Index",data:function(){return{sizeInfo:{width:""}}},methods:{getInfo:function(){window.outerWidth>window.innerWidth?this.sizeInfo.width=window.outerWidth-5+"px":this.sizeInfo.width=window.innerWidth-5+"px",console.log(window.outerWidth,window.innerWidth,this.sizeInfo.width)},downloadZip:function(){var t="https://acfly.cn/background/file/download/地面站.zip";window.open(t)},getCount:function(){var t=this;this.$axios.get("/count/count").then((function(i){200===i.status?console.log(i):t.$message.error(i.msg)})).catch((function(t){console.log(t)}))}},created:function(){this.getCount(),window.addEventListener("resize",this.getInfo),this.getInfo()},destroyed:function(){window.removeEventListener("resize",this.getInfo)}},n=r,a=(s("b860"),s("2877")),l=Object(a["a"])(n,e,o,!1,null,"7648c1bf",null);i["default"]=l.exports},6260:function(t,i,s){t.exports=s.p+"img/enterpriseWeChat_hover.5c3333a5.jpg"},"8b52":function(t,i,s){t.exports=s.p+"img/publicWeChat_hover.03e4066b.jpg"},"9d64":function(t,i,s){t.exports=s.p+"img/logo.8aee6828.png"},b860:function(t,i,s){"use strict";s("15d5")}}]);
//# sourceMappingURL=chunk-265fd907.4d472fc1.js.map