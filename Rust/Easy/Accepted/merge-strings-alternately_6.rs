impl Solution {
    pub fn merge_alternately(word1: String, word2: String) -> String {
        
        let mut result = String::new();
        let mut word1 = word1.chars();
        let mut word2 = word2.chars();
        loop {
            match (word1.next(), word2.next()) {
                (Some(c1), Some(c2)) => {
                    result.push(c1);
                    result.push(c2);
                }
                (Some(c1), None) => {
                    result.push(c1);
                    result.push_str(word1.as_str());
                    break;
                }
                (None, Some(c2)) => {
                    result.push(c2);
                    result.push_str(word2.as_str());
                    break;
                }
                (None, None) => break,
            }
        }
        result
    }
}