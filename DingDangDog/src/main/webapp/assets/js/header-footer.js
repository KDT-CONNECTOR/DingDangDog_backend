function loadLayout() {

    const isLoggedIn = localStorage.getItem('isLoggedIn') === 'true';

    const getPath = function(file) {
        return "/html/" + file;
    };

    const headerFile = isLoggedIn ? getPath('header_login.html') : getPath('header_logout.html');
    const footerFile = getPath('footer.html');

    // header
    fetch(headerFile)
        .then(function(response) {
            return response.text();
        })
        .then(function(data) {
            const headerEl = document.getElementById('header-container');
            if (headerEl) headerEl.innerHTML = data;
        })
        .catch(function() {
            console.error("헤더 로드 실패 ->", headerFile);
        });

    // footer
    fetch(footerFile)
        .then(function(response) {
            return response.text();
        })
        .then(function(data) {
            const footerEl = document.getElementById('footer-container');
            if (footerEl) footerEl.innerHTML = data;
        })
        .catch(function() {
            console.error("푸터 로드 실패 ->", footerFile);
        });
}

window.addEventListener('DOMContentLoaded', loadLayout);