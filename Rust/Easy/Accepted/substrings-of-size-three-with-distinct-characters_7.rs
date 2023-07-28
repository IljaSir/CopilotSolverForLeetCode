impl Solution {
    pub fn count_good_substrings(s: String) -> i32 {
        
        let s = s.as_bytes();
        let mut res = 0;
        for i in 0..s.len() {
            if i + 2 < s.len() {
                if s[i] != s[i + 1] && s[i] != s[i + 2] && s[i + 1] != s[i + 2] {
                    res += 1;
                }
            }
        }
        res
    }
}