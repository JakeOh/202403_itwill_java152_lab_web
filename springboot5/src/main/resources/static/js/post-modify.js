/**
 * /post/modify.html 파일에 포함.
 * 포스트 업데이트, 삭제 버튼 이벤트 처리.
 */
document.addEventListener('DOMContentLoaded', () => {
    // 삭제 버튼을 찾고, 클릭 이벤트 리스너를 설정.
    const btnDelete = document.querySelector('button#btnDelete');
    btnDelete.addEventListener('click', () => {
        const check = confirm('정말 삭제할까요?');
        if (check) {
            const id = document.querySelector('input#id').value;
            location.href = `/post/delete?id=${id}`;
        }
    });
    
    // 업데이트 버튼을 찾고, 클릭 이벤트 리스너를 설정.
    const btnUpdate = document.querySelector('button#btnUpdate');
    btnUpdate.addEventListener('click', () => {
        const title = document.querySelector('input#title').value.trim();
        const content = document.querySelector('textarea#content').value.trim();
        // trim(): 문자열 시작과 끝에 있는 모든 공백을 제거. "  abc def  ".trim() -> "abc def"
        
        if (title === '' || content === '') {
            alert('제목과 내용은 반드시 입력해야 합니다!');
            return;
        }
        
        const check = confirm('변경된 내용을 저장할까요?');
        if (check) {
            const updateForm = document.querySelector('form#updateForm');
            updateForm.submit();
        }
        
    });
    
});
