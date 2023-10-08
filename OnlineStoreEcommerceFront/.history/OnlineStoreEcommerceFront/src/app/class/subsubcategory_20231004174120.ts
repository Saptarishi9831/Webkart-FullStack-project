export class Subsubcategory {
    subSubCategoryId: number;
    subSubCategoryName: string;
    categoryid: number; 
    subcategoryId: number;

    constructor(subSubCategoryId: number, subSubCategoryName: string, categoryid: number, subcategoryId:number) {
        this.subSubCategoryId =subSubCategoryId;
        this.subSubCategoryName = subSubCategoryName;
        this. categoryid= categoryid;
        this.subcategoryId= subcategoryId;
}
}
