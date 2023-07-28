impl Solution {
    pub fn last_stone_weight_ii(stones: Vec<i32>) -> i32 {
        
        let sum: i32 = stones.iter().sum();
        let mut dp = vec![false; (sum / 2) as usize + 1];
        dp[0] = true;
        for &stone in stones.iter() {
            for i in (stone..=sum / 2).rev() {
                dp[i as usize] = dp[i as usize] || dp[(i - stone) as usize];
            }
        }
        let mut i = (sum / 2) as usize;
        while i >= 0 && !dp[i] {
            i -= 1;
        }
        sum - i as i32 * 2
    }
}