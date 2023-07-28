impl Solution {
    pub fn find_relative_ranks(score: Vec<i32>) -> Vec<String> {
        
        let mut score = score;
        score.sort_by(|a, b| b.cmp(a));
        let mut result = Vec::new();
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
        let mut score_map = HashMap::new();
        for i in 0..score.len() {
            score_map.insert(score[i], i);
        }
        for i in 0..result.len() {
            let index = score_map.get(&score[i]).unwrap();
            result[*index] = result[i].clone();
        }
        result
    }
}