impl Solution {
    pub fn is_subsequence(s: String, t: String) -> bool {
        
        let s: Vec<char> = s.chars().collect();
        let t: Vec<char> = t.chars().collect();
        let mut i = 0;
        let mut j = 0;
        while i < s.len() && j < t.len() {
            if s[i] == t[j] {
                i += 1;
            }
            j += 1;
        }
        i == s.len()
    }
}