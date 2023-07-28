impl Solution {
    pub fn find_relative_ranks(score: Vec<i32>) -> Vec<String> {
        
        let mut score = score;
        score.sort_by(|a, b| b.cmp(a));
        let mut result = vec![];
        for i in 0..score.len() {
            if i == 0 {
                result.push("Gold Medal".to_string());
            } else if i == 1 {
                result.push("Silver Medal".to_string());
            } else if i == 2 {
                result.push("Bronze Medal".to_string());
            } else {
                result.push((i + 1).to_string());
            }
        }
        for i in 0..score.len() {
            for j in 0..score.len() {
                if score[i] == score[j] {
                    score[i] = -1;
                    result[j] = result[i].clone();
                }
            }
        }
        result
    }
}