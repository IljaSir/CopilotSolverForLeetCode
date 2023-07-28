impl Solution {
    pub fn count_distinct(nums: Vec<i32>, k: i32, p: i32) -> i32 {
        
        let mut res = 0;
        let mut dp = vec![0; nums.len() + 1];
        for i in 0..nums.len() {
            let mut v = vec![0; nums.len() + 1];
            for j in 0..i {
                v[j] = dp[j];
            }
            v[i] = 1;
            for j in (i+1)..nums.len() {
                if nums[j] % p == 0 {
                    v[j] = v[j-1];
                } else {
                    v[j] = v[j-1] - dp[j-1];
                }
            }
            let mut count = 0;
            for j in 0..nums.len() {
                if nums[j] % p == 0 {
                    count += 1;
                }
                if count > k {
                    break;
                }
                res += v[j];
            }
            dp = v;
        }
        res
    }
}