impl Solution {
    pub fn num_teams(rating: Vec<i32>) -> i32 {
        
        let mut num_teams = 0;
        for i in 0..rating.len() {
            for j in i+1..rating.len() {
                for k in j+1..rating.len() {
                    if (rating[i] < rating[j] && rating[j] < rating[k]) || (rating[i] > rating[j] && rating[j] > rating[k]) {
                        num_teams += 1;
                    }
                }
            }
        }
        num_teams
    }
}