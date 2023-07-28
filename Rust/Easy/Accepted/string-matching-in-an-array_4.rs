impl Solution {
    pub fn string_matching(words: Vec<String>) -> Vec<String> {
        
        let mut result = Vec::new();
        for (i, w1) in words.iter().enumerate() {
            for (j, w2) in words.iter().enumerate() {
                if i != j && w1.contains(w2) {
                    result.push(w2.clone());
                }
            }
        }
        result.sort();
        result.dedup();
        result
    }
}