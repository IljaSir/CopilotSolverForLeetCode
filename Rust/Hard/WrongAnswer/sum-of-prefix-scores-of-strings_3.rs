impl Solution {
    pub fn sum_prefix_scores(words: Vec<String>) -> Vec<i32> {
        
        let mut scores: Vec<i32> = vec![0; words.len()];
        let mut i = 0;
        while i < words.len() {
            let mut j = 0;
            while j < words.len() {
                if i != j && words[i].starts_with(&words[j]) {
                    scores[i] += 1;
                }
                j += 1;
            }
            i += 1;
        }
        scores
    }
}