impl Solution {
    pub fn num_teams(rating: Vec<i32>) -> i32 {
        
        let mut res = 0;
        for i in 0..rating.len() {
            let mut less = 0;
            let mut greater = 0;
            for j in i+1..rating.len() {
                if rating[j] > rating[i] {
                    greater += 1;
                }
                if rating[j] < rating[i] {
                    less += 1;
                }
            }
            res += less * greater;
            res += (i as i32) * greater;
            res += (rating.len() - i - 1) as i32 * less;
        }
        res
    }
}