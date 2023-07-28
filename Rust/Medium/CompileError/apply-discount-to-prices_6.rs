impl Solution {
    pub fn discount_prices(sentence: String, discount: i32) -> String {
        
        let mut result = String::new();
        let mut words: Vec<&str> = sentence.split(' ').collect();
        for word in words.iter_mut() {
            if word.starts_with('$') {
                let mut price: Vec<char> = word.chars().collect();
                price.remove(0);
                let price: f64 = price.into_iter().collect::<String>().parse().unwrap();
                let price = price - price*discount as f64/100.0;
                *word = format!("${:.2}", price).as_str();
            }
        }
        result = words.join(" ");
        result
    }
}