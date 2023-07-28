impl Solution {
    pub fn largest_merge(word1: String, word2: String) -> String {
        
        let mut res = "".to_string();
        let mut w1 = word1;
        let mut w2 = word2;
        while !w1.is_empty() || !w2.is_empty() {
            if w1 > w2 {
                res.push(w1.remove(0));
            } else {
                res.push(w2.remove(0));
            }
        }
        res
    }
}