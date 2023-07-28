impl Solution {
    pub fn discount_prices(sentence: String, discount: i32) -> String {
        
        let mut result = String::new();
        let mut price = String::new();
        let mut flag = false;
        let mut count = 0;
        for c in sentence.chars() {
            if c == '$' {
                flag = true;
            }
            if flag {
                if c.is_digit(10) {
                    price.push(c);
                } else {
                    if !price.is_empty() {
                        let mut p = price.parse::<i32>().unwrap();
                        p = p - p * discount / 100;
                        result.push_str(&p.to_string());
                        count += 1;
                        price = String::new();
                    }
                    flag = false;
                    result.push(c);
                }
            } else {
                result.push(c);
            }
        }
        if !price.is_empty() {
            let mut p = price.parse::<i32>().unwrap();
            p = p - p * discount / 100;
            result.push_str(&p.to_string());
            count += 1;
        }
        result
    }
}