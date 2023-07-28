impl Solution {
    pub fn mask_pii(s: String) -> String {
        
        if s.contains('@') {
            let mut s = s.to_lowercase();
            let idx = s.find('@').unwrap();
            s.replace_range(idx-5..idx-1, "*****");
            s
        } else {
            let mut s = s.chars().filter(|c| c.is_digit(10)).collect::<String>();
            let l = s.len();
            let mask = format!("{}-{}-{}", "*".repeat(l-10), "*".repeat(3), s[l-4..].to_string());
            if l > 10 {
                format!("+{}-{}", "*".repeat(l-10), mask)
            } else {
                mask
            }
        }
    }
}