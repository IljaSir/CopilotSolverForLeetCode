impl Solution {
    pub fn find_relative_ranks(score: Vec<i32>) -> Vec<String> {
        
        let mut s = score.clone();
        s.sort();
        let mut res = Vec::new();
        for i in 0..score.len() {
            let idx = s.binary_search(&score[i]).unwrap();
            if idx == s.len() - 1 {
                res.push("Gold Medal".to_string());
            } else if idx == s.len() - 2 {
                res.push("Silver Medal".to_string());
            } else if idx == s.len() - 3 {
                res.push("Bronze Medal".to_string());
            } else {
                res.push((s.len() - idx).to_string());
            }
        }
        res
    }
}