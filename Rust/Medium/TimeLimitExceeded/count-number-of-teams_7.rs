impl Solution {
    pub fn num_teams(rating: Vec<i32>) -> i32 {
        
        let mut cnt = 0;
        for i in 0..rating.len() {
            for j in 0..i {
                for k in 0..j {
                    if (rating[j] > rating[i] && rating[k] > rating[j])
                        || (rating[j] < rating[i] && rating[k] < rating[j])
                    {
                        cnt += 1;
                    }
                }
            }
        }
        cnt
    }
}