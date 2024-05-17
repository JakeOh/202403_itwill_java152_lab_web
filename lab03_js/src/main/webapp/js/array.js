/**
 * array.html에 포함
 * 
 * 자바스크립트 배열: 여러 개의 원소(아이템)들을 하나의 변수 이름으로 저장하기 위한 타입.
 * 자바 배열: "한가지" 타입의 값들 여러 개를 저장하는 타입.
 * 자바스크립트 배열에서는 다른 타입의 값들이 저장될 수 있음.
 * 
 */

// div#output인 요소를 찾음:
const output = document.querySelector('div#output');

// 배열 선언 & 초기화:
const arr = [1, 2, 30, 40, -5]; // 자바: int[] arr = {1, 2, 3};

// 배열 arr의 내용을 output 영역에 씀.
let html = '';
for (let i = 0; i < arr.length; i++) {
    html += `${arr[i]}, `;
}
output.innerHTML += html + '<br/>';

// 자바 향상된 for 문장: for (변수 선언 : 배열) { ... }

html = '';
for (let val of arr) {
    html += `${val}, `;
}
output.innerHTML += html + '<br/>';
