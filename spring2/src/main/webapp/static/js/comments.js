/**
 * /post/details.jsp에 포함.
 */

document.addEventListener('DOMContentLoaded', () => {
    // btnToggleComment 버튼 요소를 찾음.
    const btnToggleComment = document.querySelector('button#btnToggleComment');
    
    // collapseComments div 요소를 부트스트랩의 Collapse 객체로 생성.
    const bsCollapse = new bootstrap.Collapse('div#collapseComments', {toggle: false});
    
    // 댓글 토글 버튼에 클릭 이벤트 리스너를 등록.
    btnToggleComment.addEventListener('click', () => {
        bsCollapse.toggle();
        
        if (btnToggleComment.innerHTML === '댓글 보기') {
            btnToggleComment.innerHTML = '댓글 감추기';
        } else {
            btnToggleComment.innerHTML = '댓글 보기';
        }
    });
    
    // 버튼 btnRegisterComment 요소를 찾음.
    const btnRegisterComment = document.querySelector('button#btnRegisterComment');
    
    // 버튼에 클릭 이벤트 리스너를 설정.
    btnRegisterComment.addEventListener('click', registerComment);
    
    // 댓글 등록 이벤트 리스너 콜백(함수):
    function registerComment() {
        // 댓글이 달릴 포스트 번호를 찾음.
        const postId = document.querySelector('input#id').value;
        
        // 댓글 내용을 찾음.
        const ctext = document.querySelector('textarea#ctext').value;
        
        // 댓글 작성자 아이디를 찾음.
        const username = document.querySelector('input#username').value;
        
        // 댓글 내용, 댓글 작성자가 비어 있는 지 체크
        if (ctext === '' || username === '') {
            alert('댓글 내용과 작성자는 반드시 입력하세요.');
            return; // 이벤트 리스너를 종료
        }
        
        // Ajax 요청에서 보낼 데이터 객체를 생성.
        /* const data = {
            postId: postId,
            ctext: ctext,
            username: username
        }; */
        const data = {postId, ctext, username};
        console.log(data);
        
        // POST 방식의 Ajax 요청을 보냄. 응답 성공/실패 콜백을 등록.
        axios
        .post('../api/comment', data)
        .then((response) => {
            // console.log(response);
            console.log(response.data); // RestController에서 보낸 응답 데이터
            if (response.data === 1) {
                alert('댓글 1개 등록 성공');
                // TODO:
            }
        })
        .catch((error) => {
            console.log(error);
        });
    }
    
});
