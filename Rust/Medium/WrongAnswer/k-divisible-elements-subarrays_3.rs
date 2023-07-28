impl Solution {
    pub fn count_distinct(nums: Vec<i32>, k: i32, p: i32) -> i32 {
        
        let mut res = 0;
        let mut dp = vec![0; nums.len()];
        let mut count = 0;
        for i in 0..nums.len() {
            if nums[i] % p == 0 {
                count += 1;
            }
            dp[i] = count;
            if i as i32 >= k {
                if nums[i - k as usize] % p == 0 {
                    count -= 1;
                }
            }
            res += dp[i];
            if i as i32 >= k {
                res -= dp[i - k as usize];
            }
        }
        res
    }
}