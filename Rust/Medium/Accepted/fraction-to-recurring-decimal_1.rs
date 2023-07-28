impl Solution {
    pub fn fraction_to_decimal(numerator: i32, denominator: i32) -> String {
        

        let mut numerator = numerator as i64;
        let mut denominator = denominator as i64;
        let mut res = String::new();
        if numerator * denominator < 0 {
            res.push('-');
        }
        numerator = numerator.abs();
        denominator = denominator.abs();
        res.push_str(&(numerator / denominator).to_string());
        numerator %= denominator;
        if numerator == 0 {
            return res;
        }
        res.push('.');
        let mut map = std::collections::HashMap::new();
        while numerator != 0 {
            if let Some(&i) = map.get(&numerator) {
                res.insert(i, '(');
                res.push(')');
                break;
            }
            map.insert(numerator, res.len());
            numerator *= 10;
            res.push_str(&(numerator / denominator).to_string());
            numerator %= denominator;
        }
        res
    }
}