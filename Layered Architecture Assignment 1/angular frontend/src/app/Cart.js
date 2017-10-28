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
var Cart = (function () {
    function Cart(cartServices) {
        this.cartServices = cartServices;
    }
    Cart.prototype.ngOnInit = function () {
        this.getCartProduct();
    };
    Cart.prototype.getCartProduct = function () {
        var _this = this;
        this.cartServices.getCartProducts().then(function (products) { return _this.products = products; });
    };
    Cart.prototype.deleteFromCart = function (prod) {
        for (var i = 0; i < this.products.length; i++) {
            if (this.products[i] == prod) {
                this.products.splice(i, 1);
                break;
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
    __metadata("design:paramtypes", [cart_service_1.CartService])
], Cart);
exports.Cart = Cart;
//# sourceMappingURL=Cart.js.map