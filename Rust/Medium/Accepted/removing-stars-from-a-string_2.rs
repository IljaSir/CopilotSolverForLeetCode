impl Solution {
    pub fn remove_stars(s: String) -> String {
        
        let mut v = Vec::new();
        for c in s.chars() {
            if c == '*' {
                v.pop();
            } else {
                v.push(c);
            }
        }
        v.into_iter().collect()
    }
}