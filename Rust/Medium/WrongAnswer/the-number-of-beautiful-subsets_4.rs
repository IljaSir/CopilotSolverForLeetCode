impl Solution {
    pub fn beautiful_subsets(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut dp = vec![0; 1024];
        dp[0] = 1;
        for &x in nums.iter() {
            for i in (0..1024).rev() {
                if i & (1 << x) == 0 {
                    dp[i | (1 << x)] += dp[i];
                }
            }
        }
        let mut ans = 0;
        for i in 0..1024 {
            let mut ok = true;
            for j in 0..10 {
                if i & (1 << j) > 0 && i & (1 << (j + k)) > 0 {
                    ok = false;
                    break;
                }
            }
            if ok {
                ans += dp[i];
            }
        }
        ans
    }
}