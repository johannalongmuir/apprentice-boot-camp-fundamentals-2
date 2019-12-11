const { Receipt } = require('./receipt.js');

let Checkout = class Checkout {
  constructor() {
    this.total = 0;
    this.numberOfA = 0;
    this.numberOfB = 0;
    this.receipt = new Receipt();
  }
};

Checkout.prototype.scan = function scan(sku) {
  if ('A' === sku) {
    this.total += 50;
    if (++this.numberOfA % 3 === 0) {
      this.total -= 20;
    }
    this.receipt.scannedA();
  } else if ('B' === sku) {
    this.total += 30;
    if (++this.numberOfB % 2 === 0) {
      this.total -= 15;
    }
    this.receipt.scannedB();
  } else if ('C' === sku) {
    this.total += 20;
    this.receipt.scannedC();
  } else if ('D' === sku) {
    this.total += 15;
    this.receipt.scannedD();
  }
};

Checkout.prototype.getTotal = function getTotal() {
  return this.total;
};

Checkout.prototype.getReceipt = function getReceipt() {
  return this.receipt.getText();
};

module.exports = {
  Checkout: Checkout
};