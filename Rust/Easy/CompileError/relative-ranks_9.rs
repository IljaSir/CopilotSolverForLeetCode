impl Solution {
    pub fn find_relative_ranks(score: Vec<i32>) -> Vec<String> {
        
        let mut score = score;
        let mut rank = vec!["".to_string(); score.len()];
        score.sort_by(|a,b| b.cmp(a));
        for i in 0..score.len() {
            let s = match i {
                0 => "Gold Medal",
                1 => "Silver Medal",
                2 => "Bronze Medal",
                _ => (i+1).to_string().as_str(),
            };
            rank[score[i] as usize] = s.to_string();
        }
        rank
    }
}