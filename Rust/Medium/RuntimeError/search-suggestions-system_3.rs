impl Solution {
    pub fn suggested_products(products: Vec<String>, search_word: String) -> Vec<Vec<String>> {
        
        let mut products = products;
        products.sort();
        let mut result = vec![];
        for i in 1..=search_word.len() {
            let mut tmp = vec![];
            for product in &products {
                if product[..i] == search_word[..i] {
                    tmp.push(product.clone());
                }
                if tmp.len() == 3 {
                    break;
                }
            }
            result.push(tmp);
        }
        result
    }
}