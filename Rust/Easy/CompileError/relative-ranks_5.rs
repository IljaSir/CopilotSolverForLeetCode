impl Solution {
    pub fn find_relative_ranks(score: Vec<i32>) -> Vec<String> {
        
        let mut scores = score.clone();
        scores.sort();
        scores.reverse();
        let mut map = std::collections::HashMap::new();
        for i in 0..scores.len() {
            let s = scores[i];
            map.insert(s, i);
        }
        let mut res = vec![];
        for s in score {
            let rank = map.get(&s).unwrap();
            let r = match rank {
                0 => "Gold Medal",
                1 => "Silver Medal",
                2 => "Bronze Medal",
                _ => &rank.to_string(),
            };
            res.push(r.to_string());
        }
        res
    }
}