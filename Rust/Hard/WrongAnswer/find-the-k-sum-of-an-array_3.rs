impl Solution {
    pub fn k_sum(nums: Vec<i32>, k: i32) -> i64 {
        
        let mut nums = nums;
        nums.sort();
        let mut k = k;
        let mut n = nums.len() as i32;
        let mut ans = 0;
        let mut dp = vec![vec![vec![0; 2]; 2000]; 2000];
        for i in 0..n {
            dp[i as usize][0][0] = 1;
        }
        for i in 0..n {
            for j in 1..k as usize {
                for l in 0..2 {
                    for m in 0..2 {
                        let mut x = i;
                        if l == 1 {
                            x += 1;
                        }
                        if m == 1 {
                            x += 1;
                        }
                        if x < n {
                            dp[x as usize][j][m] += dp[i as usize][j - 1][l];
                        }
                    }
                }
            }
        }
        for i in 0..n {
            if nums[i as usize] < 0 {
                ans += dp[i as usize][k as usize - 1][1];
            }
        }
        ans as i64
    }
}