export class Product {
    productId: number;
    productName: string;
    productPrice: number;
    productSize: string;
    productBrand: string;
    productDescription: string;
    productQuantity: number;
    productImageUrls: string;
    inStock: boolean;
    dateadded: Date;
    categoryid: number; 
    subcategoryId: number;
    subSubCategoryId: number;
    fourthlevelcategoryId:number;

    constructor(
      productId: number = 0,
      productName: string = '',
      productPrice: number = 0,
      productSize: string = '',
      productBrand: string = '',
      productDescription: string = '',
      productQuantity: number = 0,
      productImageUrls: string = '',
      inStock: boolean = false,
      dateadded: Date = new Date(),
      categoryid: number,
      subcategoryId: number,
      subSubCategoryId: number,
      fourthlevelcategoryId:number,
      ) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productSize = productSize;
        this.productBrand = productBrand;
        this.productDescription = productDescription;
        this.productQuantity = productQuantity;
        this.productImageUrls = productImageUrls;
        this.inStock = inStock;
        this.dateadded = dateadded;
        this.categoryid=categoryid;
        this.subcategoryId=subcategoryId
        this.subSubCategoryId=subSubCategoryId
        this.fourthlevelcategoryId=fourthlevelcategoryId
      }
    }
