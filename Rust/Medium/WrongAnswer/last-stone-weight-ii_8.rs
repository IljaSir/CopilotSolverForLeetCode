impl Solution {
    pub fn last_stone_weight_ii(stones: Vec<i32>) -> i32 {
        
        let n = stones.len();
        let mut dp = vec![0; 1501];
        dp[0] = 1;
        let mut sum = 0;
        for i in 0..n {
            sum += stones[i];
            for j in (stones[i]..=sum).rev() {
                dp[j as usize] |= dp[(j - stones[i]) as usize];
            }
        }
        for i in (sum/2..=sum).rev() {
            if dp[i as usize] == 1 {
                return sum - i;
            }
        }
        0
    }
}