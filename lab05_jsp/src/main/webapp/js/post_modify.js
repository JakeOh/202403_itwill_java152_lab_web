/**
 * /post/modify.jsp에 포함.
 */

// HTML DOM(Document Obejct Model) 컨텐트 로딩이 끝났을 때, 이벤트 리스너를 실행.
document.addEventListener('DOMContentLoaded', () => {
    // form 요소를 찾음:
    const modifyForm = document.querySelector('form#modifyForm');
    
    // 글 번호가 입력된 input#id 요소를 찾음:
    const inputId = document.querySelector('input#id');
    
    // 글 제목이 입력된 input#title 요소를 찾음:
    const inputTitle = document.querySelector('input#title');
    
    // 글 내용이 작성된 textares#content 요소를 찾음:
    const textareaContent = document.querySelector('textarea#content');
    
    // 삭제 버튼 찾음:
    const btnDelete = document.querySelector('button#btnDelete');
    
    // 업데이트 버튼 찾음:
    const btnUpdate = document.querySelector('button#btnUpdate');
    
    // 삭제 버튼에 클릭 이벤트 리스너를 설정.
    btnDelete.addEventListener('click', () => {
        const result = confirm('정말 삭제할까요?');
        console.log(result);
    });
    
});
