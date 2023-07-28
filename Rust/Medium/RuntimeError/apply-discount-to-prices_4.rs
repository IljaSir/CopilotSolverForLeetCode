impl Solution {
    pub fn discount_prices(sentence: String, discount: i32) -> String {
        
        let mut output = String::new();
        for word in sentence.split(' ') {
            if word.starts_with('$') {
                output.push('$');
                let price: i32 = word[1..].parse().unwrap();
                output.push_str(&format!("{:.2}", (price as f32) * (1.0 - (discount as f32) / 100.0)));
            } else {
                output.push_str(word);
            }
            output.push(' ');
        }
        output.pop();
        output
    }
}