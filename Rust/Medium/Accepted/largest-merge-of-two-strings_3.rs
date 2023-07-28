impl Solution {
    pub fn largest_merge(word1: String, word2: String) -> String {
        
        let mut res = String::new();
        let (mut word1, mut word2) = (word1.as_bytes(), word2.as_bytes());
        while !word1.is_empty() || !word2.is_empty() {
            if word1 > word2 {
                res.push(word1[0] as char);
                word1 = &word1[1..];
            } else {
                res.push(word2[0] as char);
                word2 = &word2[1..];
            }
        }
        res
    }
}