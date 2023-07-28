impl Solution {
    pub fn suggested_products(products: Vec<String>, search_word: String) -> Vec<Vec<String>> {
        
        let mut result: Vec<Vec<String>> = Vec::new();
        let mut products = products;
        products.sort();
        for i in 0..search_word.len() {
            let mut temp: Vec<String> = Vec::new();
            let mut count = 0;
            for j in 0..products.len() {
                if products[j].starts_with(&search_word[..i+1]) {
                    temp.push(products[j].clone());
                    count += 1;
                }
                if count == 3 {
                    break;
                }
            }
            result.push(temp.clone());
        }
        result
    }
}