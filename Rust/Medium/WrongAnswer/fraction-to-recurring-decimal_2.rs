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
        if numerator % denominator == 0 {
            return ans;
        }
        ans.push('.');
        let mut m = std::collections::HashMap::new();
        let mut cnt = 0;
        while numerator % denominator != 0 {
            numerator %= denominator;
            numerator *= 10;
            if m.contains_key(&numerator) {
                let pos = m.get(&numerator).unwrap();
                ans.insert_str(*pos, "(");
                ans.push(')');
                break;
            } else {
                m.insert(numerator, ans.len() + cnt);
                ans.push_str(&(numerator / denominator).to_string());
                cnt += 1;
            }
        }
        ans
    }
}