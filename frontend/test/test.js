import {getCategories, search} from "../src/rest/EbayService";
const assert = require('assert');
const should = require('chai').should();


describe('Backend', function() {
    describe('is running', function() {
        it('should return 6 entries', async () => {
            const response = await getCategories();
            assert.equal(response.data.length, 6);
        });
    });
    describe('is returning data', function() {
        it('should not be null', async () => {
            const response = await search("whatever", "11223,1233");
            should.not.equal(response.data, null);

        });
    });
});