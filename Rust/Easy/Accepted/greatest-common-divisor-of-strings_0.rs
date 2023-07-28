impl Solution {
    pub fn gcd_of_strings(str1: String, str2: String) -> String {
        
        let (mut s1, mut s2) = (str1, str2);
        if s1.len() < s2.len() {
            std::mem::swap(&mut s1, &mut s2);
        }
        let mut res = String::new();
        for i in 0..s2.len() {
            if s1.len() % (i+1) != 0 || s2.len() % (i+1) != 0 {
                continue;
            }
            let s = &s2[0..=i];
            if s1.matches(s).count() * s.len() == s1.len() && s2.matches(s).count() * s.len() == s2.len() {
                res = s.to_owned();
            }
        }
        res
    }
}