impl Solution {
    pub fn beautiful_subsets(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut dp = vec![0; 1 << 20];
        for &x in nums.iter() {
            dp[1 << x] += 1;
        }
        for mask in 1..(1 << 20) {
            if dp[mask] > 0 {
                for i in 1..20 {
                    if (mask & (1 << i)) == 0 {
                        let next = mask | (1 << i);
                        if (next & (1 << (i - k))) == 0 && (next & (1 << (i + k))) == 0 {
                            dp[next] += dp[mask];
                        }
                    }
                }
            }
        }
        dp[(1 << 20) - 1]
    }
}