impl Solution {
    pub fn can_cross(stones: Vec<i32>) -> bool {
        
        let mut dp = vec![vec![false; stones.len()]; stones.len()];
        dp[0][0] = true;
        for i in 1..stones.len() {
            if stones[i] - stones[i - 1] > i as i32 {
                return false;
            }
        }
        for i in 1..stones.len() {
            for j in (0..i).rev() {
                let k = stones[i] - stones[j];
                if k > j as i32 + 1 {
                    break;
                }
                dp[i][j] = dp[j][k as usize - 1] || dp[j][k as usize] || dp[j][k as usize + 1];
                if i == stones.len() - 1 && dp[i][j] {
                    return true;
                }
            }
        }
        false
    }
}