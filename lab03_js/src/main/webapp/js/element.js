/**
 * element.html에 포함.
 */

// button#btn1인 요소를 찾음:
const btn1 = document.querySelector('button#btn1');
// document.getElementById('btn1')

// btn1 요소에 클릭 이벤트 리스너를 설정:
btn1.addEventListener('click', function() {
    // document.getElementById(id) 사용. id가 "id1"인 요소를 찾음.
    //-> 같은 아이디를 갖는 요소가 여러개 있으면 가장 먼저 찾은 요소를 리턴.
    const div1 = document.getElementById('id1');
    // console.log(div1);
    
    // div1 요소의 바탕색을 변경:
    div1.style.backgroundColor = 'lime';
});

// button#btn2인 요소를 찾음. document.getElementById('btn2')
const btn2 = document.querySelector('button#btn2');

// btn2에 클릭 이벤트 리스너를 설정.
btn2.addEventListener('click', function() {
    // class 속성 값이 "c1"인 요소들의 바탕색을 변경.
    const divs = document.getElementsByClassName('c1'); //-> HTMLCollection(배열과 비슷)을 리턴.
//    console.log(divs);
    
    for (let e of divs) {
        e.style.backgroundColor = 'tomato';
    }
    
});

// button#btn3 요소 찾음:
const btn3 = document.querySelector('button#btn3');

// btn3에 클릭 이벤트 리스너를 설정:
btn3.addEventListener('click', () => {
    // 태그 이름이 div인 모든 요소들을 찾아서 바탕색을 변경
    const divs = document.getElementsByTagName('div');
//    console.log(divs);
    
    for (const e of divs) {
        e.style.backgroundColor = 'slateblue';
    }
});

// document.querySelector(), document.querySelectorAll():
// CSS 선택자 문법으로 아규먼트를 전달.
// tagname, #id, .classname, tagname#id.classname
// parent > child
// ancestor descendent
// element:pseudo-selector

const btn4 = document.querySelector('button#btn4');
btn4.addEventListener('click', function() {
    const div4 = document.querySelector('#id4'); // querySelector('div#id4')
//    console.log(div4);
    div4.style.backgroundColor = 'gray';
});
 
const btn5 = document.querySelector('button#btn5');
btn5.addEventListener('click', () => {
    const divs = document.querySelectorAll('div.c2'); //-> NodeList(배열과 비슷)를 리턴.
//    console.log(divs);
    
//    for (let e of divs) {
//        e.style.backgroundColor = 'dodgerblue';
//    }
    divs.forEach((x) => x.style.backgroundColor = 'violet');
});
