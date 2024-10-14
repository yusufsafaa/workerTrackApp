import { Role } from "./role";

export interface DecodedToken {
    roles:Role[];
    exp:number;
    iat:number;
  }