export class Invoice{
    
    constructor(
        public  idInv : number,
        public  productsInv : string,
        public  paidInv : number,
        public  idCustomerInv: number,
        public  date : Date)
    {}
}