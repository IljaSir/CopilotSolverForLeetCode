impl Solution {
    pub fn longest_prefix(s: String) -> String {
        
        let s = s.as_bytes();
        let mut i = 0;
        let mut j = s.len() - 1;
        let mut res = String::new();
        while i < j {
            if s[i] == s[j] {
                res.push(s[i] as char);
                i += 1;
                j -= 1;
            } else {
                i = 0;
                res.clear();
                j -= 1;
            }
        }
        res
    }
}