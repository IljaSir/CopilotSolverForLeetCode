impl Solution {
    pub fn discount_prices(sentence: String, discount: i32) -> String {
        
        let mut res = String::new();
        let mut is_price = false;
        for c in sentence.chars() {
            if c == '$' {
                is_price = true;
                res.push(c);
            } else if is_price {
                if c.is_digit(10) {
                    res.push(c);
                } else {
                    is_price = false;
                    let mut price = res.split_off(res.len() - 2);
                    let price = price.parse::<f32>().unwrap();
                    let discount = discount as f32 / 100.0;
                    let price = price * (1.0 - discount);
                    res.push_str(&format!("{:.2}", price));
                    res.push(c);
                }
            } else {
                res.push(c);
            }
        }
        res
    }
}