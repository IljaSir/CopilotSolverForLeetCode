impl Solution {
    pub fn merge_alternately(word1: String, word2: String) -> String {
        
        let mut result = String::new();
        let mut i = 0;
        while i < word1.len() && i < word2.len() {
            result.push(word1.chars().nth(i).unwrap());
            result.push(word2.chars().nth(i).unwrap());
            i += 1;
        }
        if word1.len() > word2.len() {
            result.push_str(&word1[i..]);
        } else {
            result.push_str(&word2[i..]);
        }
        result
    }
}