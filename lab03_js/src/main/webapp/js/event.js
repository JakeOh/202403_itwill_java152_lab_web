/**
 * event.html에 포함.
 */

// button#btnInput 요소를 찾음:
const btnInput = document.querySelector('button#btnInput');

// btnInput에 클릭 이벤트 리스너를 설정:
// input#itemInput에 입력된 내용을 ul 요소의 li로 추가.
btnInput.addEventListener('click', function (e) {
//    console.log(e); //-> PointerEvent
    
    const itemInput = document.querySelector('input#itemInput');
    const itemList = document.querySelector('ul#itemList');
    itemList.innerHTML += `<li> ${itemInput.value} </li>`;
    itemInput.value = '';
});

// TODO: input#itemInput2 요소에 'keydown' 이벤트 리스너를 등록:
// 엔터키가 눌렸을 때, input에 입력된 내용을 ul#itemList2의 리스트 아이템으로 추가.

// TODO: input#username 요소에 'change' 이벤트 리스너를 등록:
// input에 입력된 내용이 바뀔 때마다 div를 입력 내용으로 덮어씀.

// TODO: img#bulb 요소에 'mouseenter' 이벤트 리스너를 등록:
// img의 src를 'images/bulb_on.gif'로 변경.

// TODO: img#bulb 요소에 'mouseleave' 이벤트 리스너를 등록:
// img의 src를 'images/bulb_off.gif'로 변경.
