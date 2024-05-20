/**
 * object.html에 포함.
 */

// JSON(JavaScript Object Notaion): 자바스크립트 객체 표기법.
// { property: value, ... }

const person = {
    name: '홍길동',
    age: 16,
    phone: ['010-0000-0000', '02-0000-0000'],
};
console.log(person);

// 객체가 가지고 있는 프로퍼티 접근: (1) 참조 연산자, (2) 인덱스 연산자
console.log(person.name); // 참조 연산자: object.propertyName
console.log(person['age']); // 인덱스 연산자: object['propertyName']
console.log(person.phone[0]); // person['phone'][0]

person.age = 17; // 객체의 프로퍼티 값 변경.
console.log(person);

// 자바스크립트의 객체는, 객체가 생성된 이후에 프로퍼티를 추가할 수 있음.
person.email = 'hgd@itwill.com';
console.log(person);

// 메서드를 갖는 객체:
const score = {
    html: 100,
    css: 90,
    js: 82,
    sum: function () {
        // 객체의 프로퍼티를 접근할 때는 this 키워드를 사용.
        return this.html + this.css + this.js;
    },
    mean: function () {
        return this.sum() / 3;
    },
};

console.log(score);
console.log(score.sum()); // 메서드 호출
console.log(score.mean());

// 생성자 함수(construtor function): this 키워드를 사용해서 프로퍼티를 선언한 함수.
function Score(html, css, js) {
    // 필드
    this.html = html;
    this.css = css;
    this.js = js;
    
    // 메서드
    this.sum = function () {
        return this.html + this.css + this.js;
    };
    
    this.mean = function () {
        return this.sum() / 3;
    };
}

// 생성자 함수를 사용한 객체 생성: new 생성자함수();
const score1 = new Score(1, 2, 31);
console.log(score1);
console.log(score1.sum());
console.log(score1.mean());
