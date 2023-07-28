impl Solution {
    pub fn sum_prefix_scores(words: Vec<String>) -> Vec<i32> {
        
        let mut scores: Vec<i32> = Vec::new();
        let mut prefix: String = String::new();
        for word in words {
            let mut score = 0;
            for c in word.chars() {
                prefix.push(c);
                score += 1;
                scores.push(score);
            }
            prefix.clear();
        }
        scores
    }
}