/**
 * function.html에 포함.
 * 
 * 자바스크립트 함수 선언(정의) 방법:
 * function 함수이름([파라미터, ...]) {
 *     실행코드;
 *     [return 값;]
 * }
 * 
 * 함수 이름 앞에 리턴 타입을 선언하지 않음.
 * 파라미터를 선언할 때는 const, let, var 키워드를 사용하지 않음.
 */

// 함수 선언:
function add(x, y) {
    console.log(`x = ${x}, y = ${y}`);
    return x + y;
}

let result = add(1, 2); // 함수 호출
console.log(`result = ${result}`);

// JS 함수는 파라미터의 타입을 검사하지 않음.
result = add('Hello', 'JavaScript');
console.log(`result = ${result}`);

// JS 함수는 파라미터의 개수를 검사하지 않음.
result = add(1, 2, 3); // 선언된 파라미터보다 더 많은 아규먼트를 전달한 경우.
console.log(`result = ${result}`);

result = add(1); // 선언된 파라미터보다 적은 개수의 아규먼트를 전달한 경우.
console.log(`result = ${result}`); //-> 1 + undefined = NaN
// undefined: 초기화되지 않은 변수(값이 할당되지 않은 변수).
// NaN(Not a Number)

// JS 모든 함수는 arguments 속성(property)을 가지고 있음.
function testArgs() {
    console.log(arguments);
    for (let arg of arguments) {
        console.log(arg);
    }
}

testArgs();
testArgs('hello');
testArgs(1, '안녕');

// 숫자 2개를 아규먼트로 전달받아서 뺄셈 결과를 리턴하는 함수.
function minus(x, y) {
    return x - y;
}

result = minus(1, 2);
console.log(`result = ${result}`);
