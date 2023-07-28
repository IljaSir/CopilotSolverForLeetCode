impl Solution {
    pub fn last_stone_weight_ii(stones: Vec<i32>) -> i32 {
        
        let mut dp = vec![0; 1501];
        dp[0] = 1;
        let mut sum = 0;
        for stone in stones {
            sum += stone;
            for i in (stone..=sum).rev() {
                dp[i as usize] |= dp[(i - stone) as usize];
            }
        }
        for i in (sum / 2)..=sum {
            if dp[i as usize] == 1 {
                return sum - i;
            }
        }
        0
    }
}