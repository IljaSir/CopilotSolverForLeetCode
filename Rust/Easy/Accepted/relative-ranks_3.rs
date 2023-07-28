impl Solution {
    pub fn find_relative_ranks(score: Vec<i32>) -> Vec<String> {
        
        let mut s = score.clone();
        s.sort();
        s.reverse();
        let mut res = Vec::new();
        for i in 0..score.len() {
            let mut rank = s.iter().position(|&x| x == score[i]).unwrap() + 1;
            if rank == 1 {
                res.push("Gold Medal".to_string());
            } else if rank == 2 {
                res.push("Silver Medal".to_string());
            } else if rank == 3 {
                res.push("Bronze Medal".to_string());
            } else {
                res.push(rank.to_string());
            }
        }
        res
    }
}