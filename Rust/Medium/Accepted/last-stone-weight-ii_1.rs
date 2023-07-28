impl Solution {
    pub fn last_stone_weight_ii(stones: Vec<i32>) -> i32 {
        
        let sum = stones.iter().sum::<i32>();
        let n = stones.len();
        let mut dp = vec![false; (sum / 2 + 1) as usize];
        dp[0] = true;
        for &stone in stones.iter() {
            for i in (stone..=sum / 2).rev() {
                dp[i as usize] |= dp[(i - stone) as usize];
            }
        }
        for i in (0..=sum / 2).rev() {
            if dp[i as usize] {
                return sum - i * 2;
            }
        }
        0
    }
}