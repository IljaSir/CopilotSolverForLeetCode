impl Solution {
    pub fn convert_to_base7(num: i32) -> String {
        
        let mut n = num.abs();
        let mut res = String::new();
        while n > 0 {
            res.push_str(&(n % 7).to_string());
            n /= 7;
        }
        if res.is_empty() {
            res.push_str("0");
        }
        if num < 0 {
            res.push_str("-");
        }
        res.chars().rev().collect()
    }
}