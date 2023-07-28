impl Solution {
    pub fn fraction_to_decimal(numerator: i32, denominator: i32) -> String {
        

        let mut n = numerator as i64;
        let mut d = denominator as i64;
        let mut result = String::new();
        if n * d < 0 {
            result.push('-');
        }
        n = n.abs();
        d = d.abs();
        result.push_str(&(n / d).to_string());
        if n % d == 0 {
            return result;
        }
        result.push('.');
        let mut map = std::collections::HashMap::new();
        let mut r = n % d;
        while r != 0 {
            if map.contains_key(&r) {
                result.insert(map[&r], '(');
                result.push(')');
                break;
            }
            map.insert(r, result.len());
            r *= 10;
            result.push_str(&(r / d).to_string());
            r %= d;
        }
        result
    }
}