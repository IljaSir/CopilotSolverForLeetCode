impl Solution {
    pub fn discount_prices(sentence: String, discount: i32) -> String {
        
        sentence
            .split_whitespace()
            .map(|word| {
                if word.chars().nth(0).unwrap() == '$' {
                    let price = word[1..].parse::<f64>().unwrap();
                    format!("${:.2}", price * (100.0 - discount as f64) / 100.0)
                } else {
                    word.to_string()
                }
            })
            .collect::<Vec<String>>()
            .join(" ")
    }
}