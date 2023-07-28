impl Solution {
    pub fn discount_prices(sentence: String, discount: i32) -> String {
        
        let mut result = String::new();
        let mut price = String::new();
        let mut discount = discount as f64;
        discount /= 100.0;
        for c in sentence.chars() {
            if c == '$' {
                price.push(c);
            } else if c.is_digit(10) {
                price.push(c);
            } else {
                if price.len() > 0 {
                    let mut price: f64 = price[1..].parse().unwrap();
                    price *= 1.0 - discount;
                    price = price * 100.0;
                    price = price.round() / 100.0;
                    result.push_str(&format!("${:.2}", price));
                    price.clear();
                }
                result.push(c);
            }
        }
        if price.len() > 0 {
            let mut price: f64 = price[1..].parse().unwrap();
            price *= 1.0 - discount;
            price = price * 100.0;
            price = price.round() / 100.0;
            result.push_str(&format!("${:.2}", price));
        }
        result
    }
}