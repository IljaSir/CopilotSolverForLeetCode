impl Solution {
    pub fn greatest_letter(s: String) -> String {
        
        let mut chars = s.chars().collect::<Vec<char>>();
        chars.sort_by(|a, b| b.cmp(a));
        for c in chars {
            if c.is_uppercase() && chars.contains(&c.to_ascii_lowercase()) {
                return c.to_string();
            }
        }
        return String::new();
    }
}