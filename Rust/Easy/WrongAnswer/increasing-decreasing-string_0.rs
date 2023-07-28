impl Solution {
    pub fn sort_string(s: String) -> String {
        
        let mut s = s.chars().collect::<Vec<_>>();
        s.sort();
        let mut res = Vec::new();
        while !s.is_empty() {
            let mut i = 0;
            while i < s.len() {
                if i == 0 || s[i] != s[i - 1] {
                    res.push(s[i]);
                }
                i += 1;
            }
            s.drain(0..i);
            let mut i = s.len();
            while i > 0 {
                if i == s.len() || s[i] != s[i - 1] {
                    res.push(s[i - 1]);
                }
                i -= 1;
            }
            s.drain(i..s.len());
        }
        res.iter().collect()
    }
}