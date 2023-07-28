impl Solution {
    pub fn largest_merge(word1: String, word2: String) -> String {
        
        let mut word1 = word1.chars().collect::<Vec<char>>();
        let mut word2 = word2.chars().collect::<Vec<char>>();
        let mut result = String::new();
        while !word1.is_empty() || !word2.is_empty() {
            if word1 > word2 {
                result.push(word1.remove(0));
            } else {
                result.push(word2.remove(0));
            }
        }
        result
    }
}