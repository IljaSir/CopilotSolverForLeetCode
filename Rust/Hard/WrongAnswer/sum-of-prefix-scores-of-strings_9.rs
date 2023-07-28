impl Solution {
    pub fn sum_prefix_scores(words: Vec<String>) -> Vec<i32> {
        
        let mut res = vec![0; words.len()];
        let mut prefix = vec![' '; words.len()];
        let mut count = vec![0; words.len()];
        for (i, word) in words.iter().enumerate() {
            for (j, c) in word.chars().enumerate() {
                if prefix[j] != c {
                    prefix[j] = c;
                    count[j] = 0;
                }
                count[j] += 1;
                res[i] += count[j];
            }
        }
        res
    }
}