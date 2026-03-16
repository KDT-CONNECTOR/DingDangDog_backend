// header-footer.js
async function loadLayout() {
    // 1. 로그인 상태 확인
    const isLoggedIn = localStorage.getItem('isLoggedIn') === 'true';
    // 2. 경로
    const getPath = (file) => {
        return `/html/${file}`;
    };
    // 3. 불러올 파일 결정
    const headerFile = isLoggedIn ? getPath('header_login.html') : getPath('header_logout.html');
    const footerFile = getPath('footer.html');
    // 4. header
    try {
        const hResp = await fetch(headerFile);
        if (!hResp.ok) throw new Error(`파일이 없습니다: ${headerFile}`);
        const hData = await hResp.text();
        document.getElementById('header-container').innerHTML = hData;
    } catch (e) {
        console.error("헤더 로드 실패! 시도한 경로 ->", headerFile);
    }
    // 5. footer
    try {
        const fResp = await fetch(footerFile);
        if (!fResp.ok) throw new Error(`파일이 없습니다: ${footerFile}`);
        const fData = await fResp.text();
        document.getElementById('footer-container').innerHTML = fData;
    } catch (e) {
        console.error("푸터 로드 실패! 시도한 경로 ->", footerFile);
    }
}

window.addEventListener('DOMContentLoaded', loadLayout);