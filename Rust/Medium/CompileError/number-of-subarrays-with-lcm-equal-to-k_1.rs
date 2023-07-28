impl Solution {
    pub fn subarray_lcm(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut res = 0;
        let mut dp = vec![0; k as usize];
        let mut cur = 1;
        for &n in nums.iter() {
            cur = cur * n / gcd(cur, n);
            cur %= k;
            if cur == 0 {
                res += 1;
            }
            res += dp[cur as usize];
            dp[cur as usize] += 1;
        }
        res
    }
}