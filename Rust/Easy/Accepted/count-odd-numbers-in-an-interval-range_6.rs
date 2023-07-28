impl Solution {
    pub fn count_odds(low: i32, high: i32) -> i32 {
        
        let mut res = (high - low) / 2;
        if low % 2 == 1 || high % 2 == 1 {
            res += 1
        }
        res
    }
}