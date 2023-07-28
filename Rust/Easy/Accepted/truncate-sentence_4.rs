impl Solution {
    pub fn truncate_sentence(s: String, k: i32) -> String {
        
        let mut words = s.split_whitespace();
        let mut res = String::new();
        for _ in 0..k {
            res.push_str(words.next().unwrap());
            res.push(' ');
        }
        res.pop();
        res
    }
}