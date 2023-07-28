impl Solution {
    pub fn last_stone_weight_ii(stones: Vec<i32>) -> i32 {
        
        let mut dp = vec![false; 1501];
        dp[0] = true;
        let mut sum = 0;
        for &x in stones.iter() {
            sum += x;
            for i in (x..=sum).rev() {
                dp[i as usize] |= dp[(i - x) as usize];
            }
        }
        for i in (sum / 2)..=sum {
            if dp[i as usize] {
                return (sum - i) as i32;
            }
        }
        0
    }
}