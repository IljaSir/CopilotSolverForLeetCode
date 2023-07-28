impl Solution {
    pub fn suggested_products(products: Vec<String>, search_word: String) -> Vec<Vec<String>> {
        
        let mut res = vec![];
        let mut products = products;
        products.sort();
        let mut word = String::new();
        for c in search_word.chars() {
            word.push(c);
            let mut tmp = vec![];
            for product in products.iter() {
                if product.starts_with(&word) {
                    tmp.push(product.clone());
                    if tmp.len() == 3 {
                        break;
                    }
                }
            }
            res.push(tmp);
        }
        res
    }
}