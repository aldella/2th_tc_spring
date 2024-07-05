<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
/***start general***/

* {
  margin: 0;
  padding: 0;
  box-sizing: border-box
}

:root {
  --min-color: #2ce5c0;
  --second-color: #ffb74d;
  --thiree-color: #47369eb2;
  --four-color: #ffff
}

.order-container {
  width: 95%;
  margin: 50px auto
}

.order-list {
  width: 98%;
  border: 1px solid #ddd;
  margin: 50px auto
}

.order-list .order-list-container {
  width: 99%;
  margin: 5px auto;
  background-color: #eee;
  overflow: hidden
}

.order-list .order-list-container-1 {
  width: 97%;
  margin: 22px auto;
  background-color: var(--four-color);
  min-height: 700px;
  border-radius: 5px;
  overflow: hidden
}

/***end general***/

/***start row-1***/

.order-list .order-list-row-1 {
  display: flex;
  flex-wrap: wrap;
  text-transform: capitalize
}

.order-list .order-list-row-1 .order-item {
  flex: 1 1 50%
}

.order-list .row-1-list {
  list-style: none;
  text-align: right
}

.order-list .row-1-list li {
  display: inline-block;
  width: 5px;
  height: 5px;
  background-color: #eee;
  border-radius: 50%
}

.order-list .order-list-row-1 .order-row-1-form {
  display: flex
}

.order-list .order-list-row-1 .order-row-1-form input {
  height: 40px;
  background-color: #eee;
  border: none;
  outline: none;
  padding: 20px;
  font-size: 15px;
  font-weight: 700;
  font-style: italic;
  text-transform: capitalize;
  margin: 50px 15px 50px 0
}

.order-list .order-list-row-1 .order-row-1-form input:first-of-type {
  flex: 2
}

.order-list .order-list-row-1 .order-row-1-form input:nth-of-type(2),
.order-list .order-list-row-1 .order-row-1-form input:nth-of-type(3) {
  flex: 3
}

.order-list .order-list-row-1 .order-row-1-form input:last-of-type {
  flex: 1;
  background: linear-gradient(to right, #45379e, #614385);
  color: var(--four-color);
  line-height: 2px;
  text-transform: uppercase;
  font-weight: 500;
  font-style: normal
}

/***end row-1***/

/***start row-2***/

.order-list-row-2 {
  border-bottom: 3px solid #ddd;
  padding-bottom: 30px;
  margin-bottom: 30px
}

.order-list-row-2 .container-row-2 {
  width: 90%;
  display: flex;
  font-size: 15px;
  font-weight: bold;
  text-transform: capitalize;
  color: #3f3e3e
}

.order-list-row-2 .container-row-2 .elemnt-1-row-2 {
  flex: 1 1 30%;
  display: flex
}

.order-list-row-2 .container-row-2 .elemnt-1-row-2 input[type="checkbox"] {
  display: none
}

.order-list-row-2 .container-row-2 .elemnt-1-row-2 label {
  position: relative
}

.container-row-2 .elemnt-1-row-2 input[type="checkbox"]:checked + label::after {
  content: "";
  position: absolute;
  right: 0;
  width: 100%;
  height: 80%;
  border-radius: 5px;
  background: linear-gradient(to right, #45379e, #614385);
  box-shadow: 0 4px 5px #614385, 3px 0px 5px #45379e
}

.order-list-row-2 .container-row-2 .elemnt-1-row-2 label:before {
  content: " ";
  width: 20px;
  height: 20px;
  background-color: var(--four-color);
  border: 1px solid #ccc;
  border-radius: 5px;
  display: inline-block;
  position: relative;
  top: 0;
  left: 0
}

.order-list-row-2 .container-row-2 .elemnt-1-row-2 span {
  flex: 1;
  padding-left: 10px
}

.order-list-row-2 .container-row-2 .elemnt-1-row-2 span:nth-of-type(3) {
  flex: 2
}

.order-list-row-2 .container-row-2 .elemnt-2-row-2 {
  flex: 1 1 70%;
  display: flex
}

.order-list-row-2 .container-row-2 .elemnt-2-row-2 span {
  flex: 1
}

.order-list-row-2 .container-row-2 .elemnt-2-row-2 span:first-of-type {
  flex: 1.3
}

/***end row-2***/

/**start row-3**/

.order-list-row-3 {
  border-bottom: 2px solid #ddd;
  margin-bottom: 30px
}

.order-list-row-3 .container-row-3 {
  display: flex;
  font-size: 15px;
  font-weight: bold;
  text-transform: capitalize;
  color: #3f3e3e
}

.order-list-row-3 .container-row-3 .elemnt-1-row-3 {
  flex: 1 1 27%;
  display: flex
}

.order-list-row-3 .container-row-3 .elemnt-1-row-3 input[type="checkbox"] {
  display: none
}

.order-list-row-3 .container-row-3 .elemnt-1-row-3 label {
  position: relative
}

.container-row-3 .elemnt-1-row-3 input[type="checkbox"] + label::after {
  content: "";
  position: absolute;
  right: 0;
  width: 100%;
  height: 43%;
  border-radius: 5px;
  background: linear-gradient(to right, #45379e, #614385);
  box-shadow: 0 4px 5px #614385, 3px 0px 5px #45379e
}

.order-list-row-3 .container-row-3 .elemnt-1-row-3 label:before {
  content: " ";
  width: 20px;
  height: 20px;
  background-color: var(--four-color);
  border: 1px solid #ccc;
  border-radius: 5px;
  display: inline-block;
  position: relative;
  top: 0;
  left: 0
}

.order-list-row-3 .container-row-3 .elemnt-1-row-3 span {
  flex: 1;
  padding-left: 10px
}

.order-list-row-3 .container-row-3 .elemnt-1-row-3 span:nth-of-type(2) {
  transform: translateY(-12px)
}

.order-list-row-3 .container-row-3 .elemnt-1-row-3 span:nth-of-type(3) {
  flex: 2
}

.order-list-row-3 .container-row-3 .elemnt-2-row-3 {
  flex: 2 1 68%;
  display: flex;
  justify-content: space-between
}

.order-list-row-3 .container-row-3 .elemnt-2-row-3 span {
  flex: 1;
  margin-right: 4%
}

.order-list-row-3 .container-row-3 .elemnt-2-row-3 span:first-of-type {
  flex: 1.5
}

.order-list-row-3 .container-row-3 .elemnt-2-row-3 span:nth-of-type(2) > span {
  display: block;
  border: 1px solid #ccc;
  text-align: center;
  width: 50px;
  height: 40px;
  line-height: 40px;
  border-radius: 5px;
  margin-top: -10px
}

.order-list-row-3 .container-row-3 .elemnt-2-row-3 span:nth-of-type(4) > span {
  background-color: var(--min-color);
  height: 35px;
  color: #fff;
  line-height: 25px;
  padding: 5px 10px;
  border-radius: 5px;
  display: block
}

.order-list-row-3 .container-row-3 .elemnt-2-row-3 span:nth-of-type(5) {
  flex: 1.5
}

.order-list-row-3 .container-row-3 .row-3-list {
  list-style: none;
  flex: 1 1 5%;
  text-align: right
}

.order-list-row-3 .container-row-3 .row-3-list li {
  display: inline-block;
  width: 5px;
  height: 5px;
  background-color: #eee;
  border-radius: 50%
}

/**end row-3**/

/**start row-4**/

.order-list-row-4 {
  border-bottom: 2px solid #ddd;
  margin-bottom: 30px
}
.row-4-last {
  border: none
}

.order-list-row-4 .container-row-4 {
  display: flex;
  font-size: 15px;
  font-weight: bold;
  text-transform: capitalize;
  color: #757474
}

.order-list-row-4 .container-row-4 .elemnt-1-row-4 {
  flex: 1 1 27%;
  display: flex
}

.order-list-row-4 .container-row-4 .elemnt-1-row-4 input[type="checkbox"] {
  display: none
}

.order-list-row-4 .container-row-4 .elemnt-1-row-4 label {
  position: relative
}

.container-row-4 .elemnt-1-row-4 input[type="checkbox"]:checked + label::after {
  content: "";
  position: absolute;
  right: 0;
  width: 100%;
  height: 43%;
  border-radius: 5px;
  background: linear-gradient(to right, #45379e, #614385);
  box-shadow: 0 4px 5px #614385, 3px 0px 5px #45379e
}

.order-list-row-4 .container-row-4 .elemnt-1-row-4 label:before {
  content: " ";
  width: 20px;
  height: 20px;
  background-color: var(--four-color);
  border: 1px solid #ccc;
  border-radius: 5px;
  display: inline-block;
  position: relative;
  top: 0;
  left: 0
}

.order-list-row-4 .container-row-4 .elemnt-1-row-4 span {
  flex: 1;
  padding-left: 10px
}

.order-list-row-4 .container-row-4 .elemnt-1-row-4 span:nth-of-type(2) {
  transform: translateY(-12px)
}

.order-list-row-4 .container-row-4 .elemnt-1-row-4 span:nth-of-type(3) {
  flex: 2
}

.order-list-row-4 .container-row-4 .elemnt-2-row-4 {
  flex: 2 1 68%;
  display: flex;
  justify-content: space-between
}

.order-list-row-4 .container-row-4 .elemnt-2-row-4 span {
  flex: 1;
  margin-right: 4%
}

.order-list-row-4 .container-row-4 .elemnt-2-row-4 span:first-of-type {
  flex: 1.5
}

.order-list-row-4 .container-row-4 .elemnt-2-row-4 span:nth-of-type(2) > span {
  display: block;
  border: 1px solid #ccc;
  text-align: center;
  width: 50px;
  height: 40px;
  line-height: 40px;
  border-radius: 5px;
  margin-top: -10px
}

.order-list-row-4 .container-row-4 .elemnt-2-row-4 span:nth-of-type(4) > span {
  background-color: var(--min-color);
  height: 35px;
  color: #fff;
  line-height: 25px;
  padding: 5px 10px;
  text-align: center;
  border-radius: 5px;
  display: block
}

.container-row-4 .elemnt-2-row-4 span:nth-of-type(4) > span.orange {
  background-color: var(--second-color)
}

.order-list-row-4 .container-row-4 .elemnt-2-row-4 span:nth-of-type(5) {
  flex: 1.5
}

.order-list-row-4 .container-row-4 .row-4-list {
  list-style: none;
  flex: 1 1 5%;
  text-align: right
}

.order-list-row-4 .container-row-4 .row-4-list li {
  display: inline-block;
  width: 5px;
  height: 5px;
  background-color: #eee;
  border-radius: 50%
}

/**end row-4**/

/**start row-5**/

.order-row-5 {
  display: flex;
  justify-content: space-between;
  font-size: 15px;
  font-weight: bold;
  text-transform: capitalize;
  color: #757474
}

.order-row-5 > div span.num {
  display: inline-block;
  width: 35px;
  height: 35px;
  border: 1px solid #ccc;
  border-radius: 5px;
  line-height: 35px;
  text-align: center
}

.order-row-5 > div span.active {
  background-color: #45379e;
  color: var(--four-color)
}

.order-row-5 > div span:first-of-type {
  margin-right: 15px
}

.order-row-5 > div span:last-of-type {
  margin-left: 15px
}

/**end row-5**/

</style>
</head>
<body>
<div class="order-list">
  <div class="order-list-container">
    <div class="order-list-container-1">
      <div class="order-container">
        <!--start row-1-->

        <div class="order-list-row-1">
          <h1 class="order-item">order list</h1>
          <ul class="row-1-list order-item">
            <li></li>
            <li></li>
            <li></li>
          </ul>
          <form class="order-item order-row-1-form">
            <input type="search" placeholder="search invoice" />
            <input type="search" placeholder="search by title" />
            <input type="search" placeholder="search by phone " />
            <input type="button" value="search" />
          </form>
        </div>

        <!--end row-1-->

        <!--start row-2-->

        <div class="order-list-row-2">
          <div class="container-row-2">
            <div class="elemnt-1-row-2">
              <input type="checkbox" id="check1" />
              <label for="check1"></label>
              <span>invoice</span>
              <span>image</span>
              <span>menu &nbsp;<i class="fas fa-sort-down"></i></span>
            </div>
            <div class="elemnt-2-row-2">
              <span
                    >customer name &nbsp; <i class="fas fa-sort-down"></i
                ></span>
              <span>quantity </span>
              <span>amount &nbsp;<i class="fas fa-sort-down"></i></span>
              <span
                    >order status &nbsp;<i class="fas fa-sort-down"></i
                ></span>
              <span>phone &nbsp; <i class="fas fa-sort-down"></i></span>
            </div>
          </div>
        </div>

        <!--end row-2-->

        <!--start  row-3-->

        <div class="order-list-row-3">
          <div class="container-row-3">
            <div class="elemnt-1-row-3">
              <input type="checkbox" id="check" />
              <label for="check"></label>
              <span>invoice</span>
              <span
                    ><img
                          src="https://li0.rightinthebox.com/images/50x50/201907/xeyfxh1564542364062.jpg"
                          alt=""
                          /></span>
              <span>menu </span>
            </div>
            <div class="elemnt-2-row-3">
              <span>zain alsalama </span>
              <span><span>05</span> </span>
              <span>$2.458 </span>
              <span><span>confirmend</span> </span>
              <span>+11 24315698 </span>
            </div>
            <ul class="row-3-list">
              <li></li>
              <li></li>
              <li></li>
            </ul>
          </div>
        </div>

        <!--end  row-3-->

        <!--start  row-4-->

        <div class="order-list-row-4">
          <div class="container-row-4">
            <div class="elemnt-1-row-4">
              <input type="checkbox" id="check2" />
              <label for="check2"></label>
              <span>invoice</span>
              <span
                    ><img
                          src="https://sc01.alicdn.com/kf/UTB8XIKnElahduJk43Jaq6zM8FXaT/Fully-automatic-Fish-burger-patty-making-machine.jpg_50x50.jpg"
                          alt=""
                          /></span>
              <span>big burger </span>
            </div>
            <div class="elemnt-2-row-4">
              <span>lith alsalama </span>
              <span><span>06</span> </span>
              <span>$2.489 </span>
              <span><span class="orange">pendding</span> </span>
              <span>+11 24315698 </span>
            </div>
            <ul class="row-4-list">
              <li></li>
              <li></li>
              <li></li>
            </ul>
          </div>
        </div>
        <!--end  row-4-->

        <!--start  row-4-->

        <div class="order-list-row-4">
          <div class="container-row-4">
            <div class="elemnt-1-row-4">
              <input type="checkbox" id="check0" />
              <label for="check0"></label>
              <span>invoice</span>
              <span
                    ><img
                          src="https://www.healthyfood.com/wp-content/uploads/2017/03/Lemongrass_chicken_pasta_salad-50x50.jpg"
                          alt=""
                          /></span>
              <span>chicken pasta </span>
            </div>
            <div class="elemnt-2-row-4">
              <span>reayn alsalama </span>
              <span><span>07</span> </span>
              <span>$2.489 </span>
              <span><span>confirmend</span> </span>
              <span>+11 24315698 </span>
            </div>
            <ul class="row-4-list">
              <li></li>
              <li></li>
              <li></li>
            </ul>
          </div>
        </div>
        <!--end  row-4-->

        <!--start  row-4-->

        <div class="order-list-row-4">
          <div class="container-row-4">
            <div class="elemnt-1-row-4">
              <input type="checkbox" id="check3" />
              <label for="check3"></label>
              <span>invoice</span>
              <span
                    ><img
                          src="https://im0-tub-tr.yandex.net/i?id=c3853d5eb6589f7f3d0768d5da8452ab&n=13"
                          alt=""
                          /></span>
              <span>chicken pasta </span>
            </div>
            <div class="elemnt-2-row-4">
              <span>kenan alsalama </span>
              <span><span>06</span> </span>
              <span>$2.489 </span>
              <span><span>confirmend</span> </span>
              <span>+11 24315698 </span>
            </div>
            <ul class="row-4-list">
              <li></li>
              <li></li>
              <li></li>
            </ul>
          </div>
        </div>
        <!--end  row-4-->

        <!--start  row-4-->

        <div class="order-list-row-4">
          <div class="container-row-4">
            <div class="elemnt-1-row-4">
              <input type="checkbox" id="check4" />
              <label for="check4"></label>
              <span>invoice</span>
              <span
                    ><img
                          src="https://pimg.mycdn.me/getImage?url=http%3A%2F%2Fimg2.1001golos.ru%2Fratings%2F1515000%2F1514964%2Fpic2.jpg%3F1472154125&type=SHARE_MOB&signatureToken=H2rltZ1H_k_HjkGnK8W72A"
                          alt=""
                          /></span>
              <span>small burger </span>
            </div>
            <div class="elemnt-2-row-4">
              <span>aous alsalama </span>
              <span><span>07</span> </span>
              <span>$2.489 </span>
              <span><span class="orange">pending</span> </span>
              <span>+11 24315698 </span>
            </div>
            <ul class="row-4-list">
              <li></li>
              <li></li>
              <li></li>
            </ul>
          </div>
        </div>
        <!--end  row-4-->

        <!--start  row-4-->

        <div class="order-list-row-4 row-4-last">
          <div class="container-row-4">
            <div class="elemnt-1-row-4">
              <input type="checkbox" id="check5" />
              <label for="check5"></label>
              <span>invoice</span>
              <span
                    ><img
                          src="https://sc01.alicdn.com/kf/UTB8XIKnElahduJk43Jaq6zM8FXaT/Fully-automatic-Fish-burger-patty-making-machine.jpg_50x50.jpg"
                          alt=""
                          /></span>
              <span>big burger </span>
            </div>
            <div class="elemnt-2-row-4">
              <span>hmza alsalama </span>
              <span><span>08</span> </span>
              <span>$7.489 </span>
              <span><span>confirmend</span> </span>
              <span>+11 24315698 </span>
            </div>
            <ul class="row-4-list">
              <li></li>
              <li></li>
              <li></li>
            </ul>
          </div>
        </div>
        <!--end  row-4-->

        <!--start  row-5-->
        <div class="order-row-5">
          <p>showing 1-30/150 results</p>
          <div>
            <span>previous</span>
            <span class="num active">1</span>
            <span class="num">2</span>
            <span class="num">3</span>
            <span class="num">4</span>
            <span>next</span>
          </div>
        </div>

        <!--end  row-5-->

      </div>
    </div>
  </div>
</div>
</body>
</html>