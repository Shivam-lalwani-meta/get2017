"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var core_1 = require("@angular/core");
var cart_service_1 = require("./cart-service");
var router_1 = require("@angular/router");
var Cart = (function () {
    function Cart(cartServices, router) {
        this.cartServices = cartServices;
        this.router = router;
    }
    Cart.prototype.ngOnInit = function () {
        this.getCartProduct();
    };
    Cart.prototype.getCartProduct = function () {
        var _this = this;
        this.cartServices.getCartProducts().then(function (cartItem) { return _this.cartItem = cartItem; });
    };
    Cart.prototype.getProductDetail = function (id) {
        this.router.navigate(['/getProductDetail', id]);
    };
    Cart.prototype.deleteFromCart = function (cart) {
        for (var i = 0; i < this.cartItem.length; i++) {
            if (this.cartItem[i] == cart) {
                this.cartItem.splice(i, 1);
            }
        }
    };
    return Cart;
}());
Cart = __decorate([
    core_1.Component({
        selector: 'cart',
        templateUrl: './cart.html'
    }),
    __metadata("design:paramtypes", [cart_service_1.CartService, router_1.Router])
], Cart);
exports.Cart = Cart;
//# sourceMappingURL=Cart.js.map