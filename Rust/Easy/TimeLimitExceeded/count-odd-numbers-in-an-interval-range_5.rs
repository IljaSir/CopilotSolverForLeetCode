impl Solution {
    pub fn count_odds(low: i32, high: i32) -> i32 {
        
        let mut res = 0;
        for i in low..=high {
            if i % 2 == 1 {
                res += 1;
            }
        }
        res
    }
}