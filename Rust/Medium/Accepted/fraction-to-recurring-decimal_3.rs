impl Solution {
    pub fn fraction_to_decimal(numerator: i32, denominator: i32) -> String {
        

        let mut numerator = numerator as i64;
        let mut denominator = denominator as i64;
        let mut ans = String::new();
        if numerator * denominator < 0 {
            ans.push('-');
        }
        numerator = numerator.abs();
        denominator = denominator.abs();
        ans.push_str(&(numerator / denominator).to_string());
        numerator %= denominator;
        if numerator == 0 {
            return ans;
        }
        ans.push('.');
        let mut map = std::collections::HashMap::new();
        while numerator != 0 {
            if let Some(&i) = map.get(&numerator) {
                ans.insert(i, '(');
                ans.push(')');
                break;
            }
            map.insert(numerator, ans.len());
            numerator *= 10;
            ans.push_str(&(numerator / denominator).to_string());
            numerator %= denominator;
        }
        ans
    }
}