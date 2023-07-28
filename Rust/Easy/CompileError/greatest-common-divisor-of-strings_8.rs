impl Solution {
    pub fn gcd_of_strings(str1: String, str2: String) -> String {
        
        let (str1, str2) = (str1.as_bytes(), str2.as_bytes());
        let (len1, len2) = (str1.len(), str2.len());
        let mut res = String::new();
        for i in 0..len1.min(len2) {
            if str1[i] != str2[i] {
                break;
            }
            res.push(str1[i] as char);
        }
        if !res.is_empty() {
            let mut s1 = String::new();
            let mut s2 = String::new();
            for _ in 0..(len1 / res.len()) {
                s1.push_str(&res);
            }
            for _ in 0..(len2 / res.len()) {
                s2.push_str(&res);
            }
            if s1 == str1 && s2 == str2 {
                return res;
            }
        }
        String::new()
    }
}