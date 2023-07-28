impl Solution {
    pub fn last_stone_weight_ii(stones: Vec<i32>) -> i32 {
        
        let mut dp = vec![false; 1501];
        dp[0] = true;
        let mut sum = 0;
        for &stone in stones.iter() {
            sum += stone;
            for i in (stone..=sum).rev() {
                dp[i] = dp[i] || dp[i - stone];
            }
        }
        for i in (sum / 2..=sum).rev() {
            if dp[i] {
                return sum - 2 * i;
            }
        }
        0
    }
}