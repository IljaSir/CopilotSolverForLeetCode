impl Solution {
    pub fn discount_prices(sentence: String, discount: i32) -> String {
        
        let mut result = String::new();
        for word in sentence.split_whitespace() {
            if word.starts_with("$") {
                let price = word[1..].parse::<f32>().unwrap();
                let discount = (price * discount as f32) / 100.0;
                result.push_str(&format!("${:.2}", price - discount));
            } else {
                result.push_str(word);
            }
            result.push(' ');
        }
        result.pop();
        result
    }
}