impl Solution {
    pub fn find_ocurrences(text: String, first: String, second: String) -> Vec<String> {
        
        let mut res = Vec::new();
        let mut words = text.split_whitespace();
        if let Some(w1) = words.next() {
            if let Some(w2) = words.next() {
                if w1 == first && w2 == second {
                    if let Some(w3) = words.next() {
                        res.push(w3.to_string());
                    }
                }
            }
        }
        for w in words {
            if let Some(w3) = words.next() {
                if w == second {
                    res.push(w3.to_string());
                }
            }
        }
        res
    }
}