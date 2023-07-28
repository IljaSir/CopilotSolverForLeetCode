impl Solution {
    pub fn greatest_letter(s: String) -> String {
        
        let mut s = s;
        s.make_ascii_uppercase();
        let mut result = String::new();
        for c in s.chars() {
            if s.contains(&c.to_lowercase().to_string()) {
                result.push(c);
                break;
            }
        }
        result
    }
}