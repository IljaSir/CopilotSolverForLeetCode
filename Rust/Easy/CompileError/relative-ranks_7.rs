impl Solution {
    pub fn find_relative_ranks(score: Vec<i32>) -> Vec<String> {
        
        let mut score = score;
        let mut ranks = vec![];
        let mut map = std::collections::HashMap::new();
        score.sort_by(|a, b| b.cmp(a));
        for i in 0..score.len() {
            let rank = match i {
                0 => "Gold Medal",
                1 => "Silver Medal",
                2 => "Bronze Medal",
                _ => &(i + 1).to_string(),
            };
            map.insert(score[i], rank.to_string());
        }
        for i in 0..score.len() {
            ranks.push(map.get(&score[i]).unwrap().to_string());
        }
        ranks
    }
}