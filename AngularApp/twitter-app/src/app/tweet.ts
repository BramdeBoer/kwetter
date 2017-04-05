import { User } from './user';

export class Tweet {
    constructor(
        public id: number,
        public content: string,
        public date: string,
        public createdBy: User) {
    }
}
