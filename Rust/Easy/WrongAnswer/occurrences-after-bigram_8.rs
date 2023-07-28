impl Solution {
    pub fn find_ocurrences(text: String, first: String, second: String) -> Vec<String> {
        
        let mut res = Vec::new();
        let mut words = text.split_whitespace();
        let mut first = first;
        let mut second = second;
        let mut third = words.next();
        while let Some(w) = third {
            if first == w {
                if let Some(w) = words.next() {
                    if second == w {
                        if let Some(w) = words.next() {
                            res.push(w.to_string());
                        }
                    }
                }
            }
            first = second;
            second = w.to_string();
            third = words.next();
        }
        res
    }
}