impl Solution {
    pub fn find_relative_ranks(score: Vec<i32>) -> Vec<String> {
        
        let mut score = score;
        score.sort();
        let mut result = vec!["".to_string(); score.len()];
        for i in 0..score.len() {
            let rank = score.len() - i;
            let index = score.binary_search(&score[rank - 1]).unwrap();
            match rank {
                1 => result[index] = "Gold Medal".to_string(),
                2 => result[index] = "Silver Medal".to_string(),
                3 => result[index] = "Bronze Medal".to_string(),
                _ => result[index] = rank.to_string(),
            }
        }
        result
    }
}