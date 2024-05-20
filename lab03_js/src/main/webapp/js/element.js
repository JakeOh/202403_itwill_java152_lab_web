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
    const divs = document.getElementsByClassName('c1'); //-> 배열을 리턴.
    console.log(divs);
    
});

