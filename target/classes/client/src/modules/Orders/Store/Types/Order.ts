import { PaymentTypes } from "./PaymentTypes";


export interface IOrder {
  createdAt: Date;
  id: number;
  product: IProduct;
  customerId: number;
  cost: number;
  paymentType: PaymentTypes;


}
