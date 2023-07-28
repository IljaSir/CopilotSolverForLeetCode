impl Solution {
    pub fn sum_prefix_scores(words: Vec<String>) -> Vec<i32> {
        
        let mut result = Vec::with_capacity(words.len());
        for (i, word) in words.iter().enumerate() {
            let mut count = 0;
            for j in 0..i {
                if word.starts_with(&words[j]) {
                    count += 1;
                }
            }
            result.push(count);
        }
        result
    }
}