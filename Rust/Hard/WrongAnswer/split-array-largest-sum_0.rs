impl Solution {
    pub fn split_array(nums: Vec<i32>, k: i32) -> i32 {
        
        let n = nums.len();
        let mut sums = vec![0; n + 1];
        for i in 0..n {
            sums[i + 1] = sums[i] + nums[i];
        }
        let mut dp = vec![vec![0; k as usize + 1]; n + 1];
        for i in 0..=n {
            dp[i][0] = sums[n] - sums[i];
        }
        for i in (0..n).rev() {
            for j in 1..=k as usize {
                let mut min = std::i32::MAX;
                for l in i + 1..=n {
                    let val = std::cmp::max(dp[l][j - 1], sums[l] - sums[i]);
                    if val < min {
                        min = val;
                    } else {
                        break;
                    }
                }
                dp[i][j] = min;
            }
        }
        dp[0][k as usize]
    }
}