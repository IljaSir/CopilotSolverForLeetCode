impl Solution {
    pub fn fraction_to_decimal(numerator: i32, denominator: i32) -> String {
        

        let mut numerator = numerator as i64;
        let mut denominator = denominator as i64;
        let mut result = String::new();
        if (numerator < 0) ^ (denominator < 0) {
            result.push('-');
        }
        numerator = numerator.abs();
        denominator = denominator.abs();
        result.push_str(&(numerator / denominator).to_string());
        numerator %= denominator;
        if numerator == 0 {
            return result;
        }
        result.push('.');
        let mut map = std::collections::HashMap::new();
        while numerator != 0 {
            numerator *= 10;
            if let Some(&index) = map.get(&numerator) {
                result.insert(index, '(');
                result.push(')');
                break;
            }
            map.insert(numerator, result.len());
            result.push_str(&(numerator / denominator).to_string());
            numerator %= denominator;
        }
        result
    }
}