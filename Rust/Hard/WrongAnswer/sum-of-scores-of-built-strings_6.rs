impl Solution {
    pub fn sum_scores(s: String) -> i64 {
        
        let mut scores = vec![0; s.len()];
        let mut prefix = vec![0; s.len()];
        let mut max = 0;
        for (i, c) in s.chars().rev().enumerate() {
            if i == 0 {
                scores[i] = 1;
                prefix[i] = 1;
            } else {
                if c == s.chars().nth(i - 1).unwrap() {
                    scores[i] = scores[i - 1] + 1;
                    prefix[i] = prefix[i - 1] + 1;
                } else {
                    scores[i] = 1;
                    prefix[i] = 1;
                }
            }
            if prefix[i] > max {
                max = prefix[i];
            } else {
                scores[i] = max;
            }
        }
        scores.into_iter().sum()
    }
}