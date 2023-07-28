impl Solution {
    pub fn gcd_of_strings(str1: String, str2: String) -> String {
        
        let (mut s1, mut s2) = (str1, str2);
        while s1.len() != s2.len() {
            if s1.len() > s2.len() {
                s1 = s1.replace(&s2, "");
            } else {
                s2 = s2.replace(&s1, "");
            }
        }
        if s1 == s2 {
            s1
        } else {
            "".to_string()
        }
    }
}