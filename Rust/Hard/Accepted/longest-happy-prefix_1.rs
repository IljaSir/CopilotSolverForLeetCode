impl Solution {
    pub fn longest_prefix(s: String) -> String {
        
        let s: Vec<char> = s.chars().collect();
        let mut lps = vec![0; s.len()];
        let mut i = 1;
        let mut len = 0;
        while i < s.len() {
            if s[i] == s[len] {
                len += 1;
                lps[i] = len;
                i += 1;
            } else {
                if len != 0 {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i += 1;
                }
            }
        }
        s[..lps[s.len() - 1]].iter().collect()
    }
}