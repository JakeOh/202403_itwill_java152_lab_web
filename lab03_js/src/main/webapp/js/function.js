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

// default parameter: 기본값이 설정된 파라미터
function multiply(x, y = 1) {
    return x * y;
}

result = multiply(2, 3); // 아규먼트 y를 전달하면 기본값은 무시됨.
console.log(`result = ${result}`);

result = multiply(2); // 아규먼트 y를 전달하지 않으면 기본값이 사용됨.
console.log(`result = ${result}`);

/*
 * JS 함수는 객체(object)!!
 * 1. 프로퍼티(property)를 가질 수 있음. (예) arguments
 * 2. 변수에 저장할 수 있음.
 * 3. 함수를 호출할 때 아규먼트로 함수 (객체)를 전달할 수 있음.
 * 4. 함수 내부에서 다른 함수를 선언(정의)할 수 있음.
 * 5. 함수 (객체)를 리턴할 수 있음.
 */

const plus = add; // 함수 객체 add를 변수 plus에 할당(저장).
console.log(plus); //-> plus: 함수 객체
console.log(plus(100, 200)); //-> plus(100, 200): 함수 호출.

// 익명 함수(anonymous function): 이름이 없는 함수.
const divide = function (x, y) {
    return x / y;
};

result = divide(1, 2);
console.log(`result = ${result}`);

// 화살표 함수(arrow function): 익명 함수를 간단히 표현하는 문법.
// (param, ...) => { ... }
// (param, ...) => 리턴값
const subtract = (x, y) => x - y; // 화살표 함수를 변수 subtract에 저장.
result = subtract(1, 2);
console.log(`result = ${result}`);

// 함수 (객체)를 아규먼트로 전달받는 함수
function calculate(x, y, op) {
    return op(x, y);
}

console.log(calculate(1, 2, add));
console.log(calculate(1, 2, function (x, y) {return x - y;}));
console.log(calculate(1, 2, (x, y) => x / y));
//-> 이벤트 리스너(핸들러) 설정할 때 많이 사용되는 코드 패턴.
// 콜백(callback): (나중에 호출하기 위해서) 아규먼트로 전달하는 함수.


// 지역(내부) 함수: 함수 안에서 선언하는 함수.
function increase(n) {
    // 지역 함수는 바깥 함수의 지역 변수(파라미터 포함)들을 사용할 수 있음!
    function addN(x) {
        return x + n;
    }
    
    return addN; // 함수 객체 리턴.
}

const increaseTwo = increase(2);
console.log(increaseTwo);
console.log(increaseTwo(100));

const increaseTen = increase(10);
console.log(increaseTen(100));

console.log(increase(1)(10));
