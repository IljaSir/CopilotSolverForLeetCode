impl Solution {
    pub fn find_ocurrences(text: String, first: String, second: String) -> Vec<String> {
        
        let mut res: Vec<String> = Vec::new();
        let mut words = text.split_whitespace();
        let mut w1 = words.next();
        let mut w2 = words.next();
        while let Some(w3) = words.next() {
            if w1 == Some(&first.as_str()) && w2 == Some(&second.as_str()) {
                res.push(w3.to_string());
            }
            w1 = w2;
            w2 = Some(w3);
        }
        res
    }
}