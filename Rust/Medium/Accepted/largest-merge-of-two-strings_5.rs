impl Solution {
    pub fn largest_merge(word1: String, word2: String) -> String {
        
        let mut word1 = word1.as_bytes().to_vec();
        let mut word2 = word2.as_bytes().to_vec();
        let mut result = Vec::new();
        while !word1.is_empty() || !word2.is_empty() {
            if word1 > word2 {
                result.push(word1.remove(0));
            } else {
                result.push(word2.remove(0));
            }
        }
        String::from_utf8(result).unwrap()
    }
}