function includeLayout() {

    var headerContainer = document.getElementById('header-container');
    var footerContainer = document.getElementById('footer-container');

    var isLoggedIn = localStorage.getItem('isLoggedIn') === 'true';

    var headerFile = isLoggedIn ? './header_login.html' : './header_logout.html';

    // header
    if (headerContainer) {
        fetch(headerFile)
            .then(function (response) {
                return response.text();
            })
            .then(function (data) {
                headerContainer.innerHTML = data;
            })
            .catch(function (error) {
                console.error('헤더 로드 실패:', error);
            });
    }

    // footer
    if (footerContainer) {
        fetch('./footer.html')
            .then(function (response) {
                return response.text();
            })
            .then(function (data) {
                footerContainer.innerHTML = data;
            })
            .catch(function (error) {
                console.error('푸터 로드 실패:', error);
            });
    }
}