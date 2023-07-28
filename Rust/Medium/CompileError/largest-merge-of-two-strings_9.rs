impl Solution {
    pub fn largest_merge(word1: String, word2: String) -> String {
        
        let mut ans = String::new();
        let (mut word1, mut word2) = (word1.chars().collect(), word2.chars().collect());
        while !word1.is_empty() || !word2.is_empty() {
            if word1 > word2 {
                ans.push(word1.remove(0));
            } else {
                ans.push(word2.remove(0));
            }
        }
        ans
    }
}