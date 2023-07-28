impl Solution {
    pub fn can_cross(stones: Vec<i32>) -> bool {
        
        let n = stones.len();
        let mut dp = vec![vec![false; n]; n];
        dp[0][0] = true;
        for i in 1..n {
            if stones[i] - stones[i - 1] > i as i32 {
                return false;
            }
        }
        for i in 1..n {
            for j in (0..i).rev() {
                let k = stones[i] - stones[j];
                if k > j as i32 + 1 {
                    break;
                }
                dp[i][k as usize] = dp[j][k as usize]
                    || (k > 1 && dp[j][(k - 1) as usize])
                    || dp[j][(k + 1) as usize];
                if i == n - 1 && dp[i][k as usize] {
                    return true;
                }
            }
        }
        false
    }
}