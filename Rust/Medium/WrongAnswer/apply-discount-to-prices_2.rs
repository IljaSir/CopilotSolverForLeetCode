impl Solution {
    pub fn discount_prices(sentence: String, discount: i32) -> String {
        
        sentence.split(' ').map(|s| {
            if s.starts_with('$') {
                let mut price = s[1..].parse::<i32>().unwrap();
                price = price * (100 - discount) / 100;
                let mut res = String::new();
                res.push('$');
                res.push_str(&price.to_string());
                res.push_str(".00");
                res
            } else {
                s.to_string()
            }
        }).collect::<Vec<String>>().join(" ")
    }
}