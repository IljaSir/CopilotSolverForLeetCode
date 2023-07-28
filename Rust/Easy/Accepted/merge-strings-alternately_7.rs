impl Solution {
    pub fn merge_alternately(word1: String, word2: String) -> String {
        
        let mut result = String::new();
        let mut w1 = word1.chars();
        let mut w2 = word2.chars();
        loop {
            match (w1.next(), w2.next()) {
                (Some(c1), Some(c2)) => {
                    result.push(c1);
                    result.push(c2);
                },
                (Some(c1), None) => {
                    result.push(c1);
                },
                (None, Some(c2)) => {
                    result.push(c2);
                },
                (None, None) => {
                    break;
                },
            }
        }
        result
    }
}