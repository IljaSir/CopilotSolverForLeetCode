impl Solution {
    pub fn find_ocurrences(text: String, first: String, second: String) -> Vec<String> {
        
        let mut result = Vec::new();
        let mut words = text.split_whitespace();
        let mut prev = words.next();
        let mut cur = words.next();
        while let (Some(p), Some(c)) = (prev, cur) {
            if p == first && c == second {
                if let Some(t) = words.next() {
                    result.push(t.to_string());
                }
            }
            prev = cur;
            cur = words.next();
        }
        result
    }
}