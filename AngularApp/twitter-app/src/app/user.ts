export class User {
    constructor(
        public id: number,
        public username: string,
        public name?: string,
        public bio?: string,
        public location?: string,
        public avatarURL?: string,
        public websiteURL?: string) {
    }
}
