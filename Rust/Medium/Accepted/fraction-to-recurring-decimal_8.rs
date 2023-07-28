impl Solution {
    pub fn fraction_to_decimal(numerator: i32, denominator: i32) -> String {
        

        let mut result = String::new();
        let mut numerator = numerator as i64;
        let mut denominator = denominator as i64;
        if numerator * denominator < 0 {
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
        let mut index = result.len();
        while numerator != 0 {
            if map.contains_key(&numerator) {
                let i = map.get(&numerator).unwrap();
                result.insert(*i, '(');
                result.push(')');
                return result;
            }
            map.insert(numerator, index);
            numerator *= 10;
            result.push_str(&(numerator / denominator).to_string());
            numerator %= denominator;
            index += 1;
        }
        result
    }
}