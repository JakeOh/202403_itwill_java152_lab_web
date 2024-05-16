/**
 * for.html에 포함. 
 */

// 아이디가 result인 HTML 요소를 찾음:
const result = document.getElementById('result');

// result 요소에 추가할 HTML 코드를 저장하기 위한 문자열 변수:
let html = '';

for (let x = 1; x < 10; x++) {
    html += `2 x ${x} = ${2 * x} <br/>`; // ``: 문자열 템플릿
}
result.innerHTML += html;

result.innerHTML += '<hr/>';

// result에 구구단 3단 ~ 9단까지 덧붙임(append).
html = '';
for (let x = 3; x < 10; x++) {
    for (let y = 1; y < 10; y++) {
        html += `${x} x ${y} = ${x * y} <br/>`;
    }
    html += '---------- <br/>';
}
result.innerHTML += html;
result.innerHTML += '<hr/>';

// break를 사용해서 2단은 2x2까지, 3단은 3x3까지, ..., 9단은 9x9까지 출력.
html = '';
for (let x = 2; x < 10; x++) {
    for (let y = 1; y < 10; y++) {
        html += `${x} x ${y} = ${x * y} <br/>`;
        if (x == y) {
            break;
        }
    }
    html += '--------------- <br/>';
}
result.innerHTML += html;
