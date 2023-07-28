impl Solution {
    pub fn find_relative_ranks(score: Vec<i32>) -> Vec<String> {
        
        let mut sorted_scores = score.clone();
        sorted_scores.sort();
        sorted_scores.reverse();
        let mut ranks = vec![];
        for s in score {
            let rank = sorted_scores.iter().position(|&x| x == s).unwrap() + 1;
            if rank == 1 {
                ranks.push("Gold Medal".to_string());
            } else if rank == 2 {
                ranks.push("Silver Medal".to_string());
            } else if rank == 3 {
                ranks.push("Bronze Medal".to_string());
            } else {
                ranks.push(rank.to_string());
            }
        }
        ranks
    }
}