impl Solution {
    pub fn merge_alternately(word1: String, word2: String) -> String {
        
        let mut res = String::new();
        let mut i = 0;
        let mut j = 0;
        while i < word1.len() || j < word2.len() {
            if i < word1.len() {
                res.push(word1.chars().nth(i).unwrap());
                i += 1;
            }
            if j < word2.len() {
                res.push(word2.chars().nth(j).unwrap());
                j += 1;
            }
        }
        res
    }
}