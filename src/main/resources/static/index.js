angular.module('app', [])
    .controller('indexController', function ($scope, $http) {
        const contextPath = 'http://localhost:8080/app';

        $scope.currentPage = 0;
        $scope.pageSize = 10;
        $scope.totalPages = 0;
        $scope.minPrice = null;
        $scope.maxPrice = null;

        $scope.loadProducts = function () {
            $http.get(contextPath + '/products', {
                params: {
                    page: $scope.currentPage,
                    size: $scope.pageSize,
                    minPrice: $scope.minPrice,
                    maxPrice: $scope.maxPrice
                }
            }).then(function (response) {
                $scope.ProductsList = response.data.content;
                $scope.totalPages = response.data.totalPages;
            });
        };

        $scope.deleteProduct = function (productId) {
            $http.get(contextPath + '/products/delete/' + productId)
                .then(function (response) {
                    $scope.loadProducts();
                });
        };

        $scope.addProduct = function () {
            $http.post(contextPath + '/products', $scope.newProduct)
                .then(function (response) {
                    $scope.loadProducts();
                    $scope.newProduct = {};
                }, function (error) {
                    console.error("Error adding product:", error);
                });
        };

        $scope.filterByPrice = function () {
            $scope.currentPage = 0;
            $scope.loadProducts();
        };

        $scope.nextPage = function () {
            if ($scope.currentPage < $scope.totalPages - 1) {
                $scope.currentPage++;
                $scope.loadProducts();
            }
        };

        $scope.prevPage = function () {
            if ($scope.currentPage > 0) {
                $scope.currentPage--;
                $scope.loadProducts();
            }
        };

        $scope.addToCart = function (productId) {
            $http.get(contextPath + '/cart/add/' + productId)
                .then(function (response) {
                    console.log("Продукт был добавлен в корзину");
                }, function (error) {
                    console.error("Ошибка добавления продукта в корзину", error);
                });
        };

        $scope.loadProducts();
    })
    .controller('cartController', function ($scope, $http) {
        const contextPath = 'http://localhost:8080/app';

        $scope.loadCart = function () {
            $http.get(contextPath + '/cart')
                .then(function (response) {
                    $scope.cartProducts = response.data;
                });
        };

        $scope.removeFromCart = function (productId) {
            $http.post(contextPath + '/cart/remove/' + productId)
                .then(function (response) {
                    console.log("Продукт был удален из корзины");
                    $scope.loadCart();
                }, function (error) {
                    console.error("Ошибка удаления продукта из корзины", error);
                });
        };

        $scope.clearCart = function () {
            $http.post(contextPath + '/cart/clear')
                .then(function (response) {
                    console.log("Корзина очищена");
                    $scope.loadCart();
                }, function (error) {
                    console.error("Ошибка очистки корзины", error);
                });
        };

        $scope.loadCart();
    });
