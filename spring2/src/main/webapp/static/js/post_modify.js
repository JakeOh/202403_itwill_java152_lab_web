/**
 * /post/modify.jsp에 포함.
 */

document.addEventListener('DOMContentLoaded', () => {
    const modifyForm = document.querySelector('form#modifyForm');
    const inputId = document.querySelector('input#id');
    const inputTitle = document.querySelector('input#title');
    const textContent = document.querySelector('textarea#content');
    const btnDelete = document.querySelector('button#btnDelete');
    const btnUpdate = document.querySelector('button#btnUpdate');
    
    // 삭제 버튼의 클릭 이벤트 리스너:
    btnDelete.addEventListener('click', () => {
        const result = confirm('정말 삭제할까요?');
        if (result) { // 사용자가 [확인]을 선택했을 때
            // GET 방식의 delete 요청을 서버로 보냄.
            location.href = `delete?id=${inputId.value}`;
        }
    });
    
});
