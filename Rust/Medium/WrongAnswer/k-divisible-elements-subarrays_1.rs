impl Solution {
    pub fn count_distinct(nums: Vec<i32>, k: i32, p: i32) -> i32 {
        
        let mut dp = vec![0; nums.len()];
        let mut cnt = 0;
        for i in 0..nums.len() {
            if nums[i] % p == 0 {
                cnt += 1;
            }
            dp[i] = cnt;
        }
        let mut ans = 0;
        for i in 0..nums.len() {
            let mut j = i + 1;
            let mut c = dp[i];
            while j < nums.len() && j - i < k as usize {
                if nums[j] % p == 0 {
                    c += 1;
                }
                ans += c - dp[i];
                j += 1;
            }
            ans += c - dp[i];
        }
        ans
    }
}