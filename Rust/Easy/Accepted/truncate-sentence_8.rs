impl Solution {
    pub fn truncate_sentence(s: String, k: i32) -> String {
        
        let mut i = 0;
        let mut j = 0;
        for _ in 0..k {
            j = s[i..].find(' ').unwrap_or(s.len() - i) + i;
            i = j + 1;
        }
        s[..j].to_string()
    }
}