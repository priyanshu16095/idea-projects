import axios from "axios";

const URL = "http://localhost:8000/app";
const POST_URL = "http://localhost:8000/app/add";
const GET_URL = "http://localhost:8000/app/contact";

const contactService = {
    async createContact(contact) {
        return await axios.post(POST_URL, contact);
    },
};

export default contactService;
