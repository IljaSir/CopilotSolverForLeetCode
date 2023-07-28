impl Solution {
    pub fn largest_merge(word1: String, word2: String) -> String {
        
        let mut w1 = word1.as_bytes().to_vec();
        let mut w2 = word2.as_bytes().to_vec();
        let mut res = Vec::new();
        while !w1.is_empty() && !w2.is_empty() {
            if w1 > w2 {
                res.push(w1.remove(0));
            } else {
                res.push(w2.remove(0));
            }
        }
        res.append(&mut w1);
        res.append(&mut w2);
        String::from_utf8(res).unwrap()
    }
}