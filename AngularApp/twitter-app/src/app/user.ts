export class User {
    constructor(
        public id: number,
        public name: string,
        public username: string,
        public bio: string,
        public location,
        public avatarURL: string,
        public websiteURL: string) {
    }
}
