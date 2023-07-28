impl Solution {
    pub fn fraction_to_decimal(numerator: i32, denominator: i32) -> String {
        

        let mut res = String::new();
        if (numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0) {
            res.push('-');
        }
        let numerator = numerator.abs() as i64;
        let denominator = denominator.abs() as i64;
        res.push_str(&(numerator / denominator).to_string());
        let mut remainder = numerator % denominator;
        if remainder == 0 {
            return res;
        }
        res.push('.');
        let mut map = std::collections::HashMap::new();
        while remainder != 0 {
            if let Some(&i) = map.get(&remainder) {
                res.insert(i, '(');
                res.push(')');
                break;
            }
            map.insert(remainder, res.len());
            remainder *= 10;
            res.push_str(&(remainder / denominator).to_string());
            remainder %= denominator;
        }
        res
    }
}