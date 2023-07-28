impl Solution {
    pub fn suggested_products(products: Vec<String>, search_word: String) -> Vec<Vec<String>> {
        
        let mut products = products;
        products.sort();
        let mut res = vec![];
        let mut prefix = String::new();
        for c in search_word.chars() {
            prefix.push(c);
            let mut tmp = vec![];
            for p in products.iter() {
                if p.starts_with(&prefix) {
                    tmp.push(p.clone());
                }
                if tmp.len() == 3 {
                    break;
                }
            }
            res.push(tmp);
        }
        res
    }
}