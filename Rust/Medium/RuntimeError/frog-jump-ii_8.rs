impl Solution {
    pub fn max_jump(stones: Vec<i32>) -> i32 {
        
        let mut dp = vec![0; stones.len()];
        let mut left = 0;
        for i in 1..stones.len() {
            while stones[i] - stones[left] > i as i32 - left as i32 {
                left += 1;
            }
            dp[i] = (left..i).map(|j| dp[j] + (i as i32 - j as i32).abs()).min().unwrap();
        }
        dp[stones.len() - 1]
    }
}