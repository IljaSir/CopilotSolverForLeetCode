impl Solution {
    pub fn gcd_of_strings(str1: String, str2: String) -> String {
        
        if str1.len() < str2.len() {
            return Solution::gcd_of_strings(str2, str1);
        } else if !str1.starts_with(&str2) {
            return String::new();
        } else if str2.is_empty() {
            return str1;
        } else {
            return Solution::gcd_of_strings(str1[str2.len()..].to_string(), str2);
        }
    }
}