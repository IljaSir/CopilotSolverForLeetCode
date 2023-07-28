impl Solution {
    pub fn subarray_gcd(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut count = 0;
        let mut dp = vec![0; nums.len()];
        for i in 0..nums.len() {
            if nums[i] % k == 0 {
                count += 1;
                dp[i] = 1;
            }
        }
        for i in 1..nums.len() {
            if dp[i] == 0 {
                continue;
            }
            for j in i+1..nums.len() {
                if nums[j] % k == 0 {
                    count += 1;
                    dp[j] = 1;
                } else {
                    let gcd = Solution::gcd(nums[j], nums[i]);
                    if gcd % k == 0 {
                        count += 1;
                        dp[j] = 1;
                    }
                }
            }
        }
        count
    }
    fn gcd(a: i32, b: i32) -> i32 {
        if a == 0 {
            b
        } else {
            Solution::gcd(b%a, a)
        }
    }
}