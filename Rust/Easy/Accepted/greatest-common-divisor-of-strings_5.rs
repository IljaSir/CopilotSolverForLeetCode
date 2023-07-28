impl Solution {
    pub fn gcd_of_strings(str1: String, str2: String) -> String {
        
        let mut str1 = str1;
        let mut str2 = str2;
        while str1 != str2 {
            if str1.len() < str2.len() {
                std::mem::swap(&mut str1, &mut str2);
            }
            if !str1.starts_with(&str2) {
                return String::new();
            }
            str1 = str1[str2.len()..].to_string();
        }
        str1
    }
}