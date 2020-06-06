import axios from 'axios';
import 'regenerator-runtime';

const server = `http://localhost:8080`;
const config = {
    headers: {'Access-Control-Allow-Origin': '*'}
};

const axiosCurried = (headers) => (address) => axios.get(address, headers);
const axiosWithHeaders = (address) => axiosCurried(config)(address);

export const getExamples = async () => await axiosWithHeaders(`${server}/get_examples`);
export const getCategories = async () => await axiosWithHeaders(`${server}/categories`);
export const search = async (query, categories) => await axiosWithHeaders(`${server}/search?query=${query}&categoryIds=${categories}`);
export const loadMore = async (url) => await axiosWithHeaders(`${server}/load_more?url=${encodeURIComponent(url)}`);
