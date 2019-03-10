import { UserRank } from './UserRanks';
import { UserRoles } from "./UserRoles";

export interface IUserState {
  firsName: string;
  lastName: string;
  age: number;
  email: string;
  password: string;
  role: UserRoles;
  rank: UserRank;
  isAdmin: boolean;
  isCustomer: boolean;
  orders: IOrder[];
  country: string;

}
