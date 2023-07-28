impl Solution {
    pub fn truncate_sentence(s: String, k: i32) -> String {
        
        let mut result = String::new();
        let mut i = 0;
        for c in s.chars() {
            if c == ' ' {
                i += 1;
                if i == k {
                    break;
                }
            }
            result.push(c);
        }
        result
    }
}