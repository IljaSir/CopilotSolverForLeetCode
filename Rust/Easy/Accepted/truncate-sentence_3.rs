impl Solution {
    pub fn truncate_sentence(s: String, k: i32) -> String {
        
        let mut res = String::new();
        let mut count = 0;
        for c in s.chars() {
            if c == ' ' {
                count += 1;
            }
            if count == k {
                break;
            }
            res.push(c);
        }
        res
    }
}