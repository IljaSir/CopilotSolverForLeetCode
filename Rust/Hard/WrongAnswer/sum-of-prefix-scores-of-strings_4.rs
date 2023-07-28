impl Solution {
    pub fn sum_prefix_scores(words: Vec<String>) -> Vec<i32> {
        
        let mut result: Vec<i32> = vec![0; words.len()];
        let mut score: i32 = 0;
        for (i, word) in words.iter().enumerate() {
            score += word.len() as i32;
            result[i] = score;
        }
        result
    }
}