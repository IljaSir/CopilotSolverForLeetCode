impl Solution {
    pub fn find_number_of_lis(nums: Vec<i32>) -> i32 {
        

        let n = nums.len();
        let mut dp = vec![1; n];
        let mut cnt = vec![1; n];
        let mut ans = 0;
        let mut max_len = 0;
        for i in 0..n {
            for j in 0..i {
                if nums[j] < nums[i] {
                    if dp[j] + 1 > dp[i] {
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                    } else if dp[j] + 1 == dp[i] {
                        cnt[i] += cnt[j];
                    }
                }
            }
            if dp[i] > max_len {
                max_len = dp[i];
                ans = cnt[i];
            } else if dp[i] == max_len {
                ans += cnt[i];
            }
        }
        ans
    }
}