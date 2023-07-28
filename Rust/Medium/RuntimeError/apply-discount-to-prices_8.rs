impl Solution {
    pub fn discount_prices(sentence: String, discount: i32) -> String {
        
        let mut res = String::new();
        let mut i = 0;
        let mut j = 0;
        let mut price = false;
        let mut d = discount as f64 / 100.0;
        while i < sentence.len() {
            let c = sentence.chars().nth(i).unwrap();
            if c == '$' {
                price = true;
                j = i + 1;
            }
            if price {
                if c == ' ' || i == sentence.len() - 1 {
                    let mut p = sentence[j..i].to_string();
                    if i == sentence.len() - 1 {
                        p.push(c);
                    }
                    let p = p.parse::<f64>().unwrap();
                    let p = p - p * d;
                    res.push_str(&format!("${:.2}", p));
                    price = false;
                }
            } else {
                res.push(c);
            }
            i += 1;
        }
        res
    }
}