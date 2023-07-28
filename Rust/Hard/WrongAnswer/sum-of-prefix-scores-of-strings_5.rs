impl Solution {
    pub fn sum_prefix_scores(words: Vec<String>) -> Vec<i32> {
        
        let mut result = vec![0; words.len()];
        let mut count = vec![0; 26];
        for (i, word) in words.iter().enumerate() {
            for c in word.chars() {
                let idx = (c as u8 - 'a' as u8) as usize;
                count[idx] += 1;
                result[i] += count[idx];
            }
        }
        result
    }
}