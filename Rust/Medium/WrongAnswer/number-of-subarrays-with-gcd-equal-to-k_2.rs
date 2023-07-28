impl Solution {
    pub fn subarray_gcd(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut dp = vec![0; k as usize];
        for n in nums {
            let mut t = vec![0; k as usize];
            for i in 0..k {
                let j = i + n % k;
                if j < k {
                    t[j as usize] += dp[i as usize] + 1;
                }
            }
            dp = t;
        }
        dp[0]
    }
}