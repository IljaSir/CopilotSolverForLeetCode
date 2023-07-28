impl Solution {
    pub fn smallest_subarrays(nums: Vec<i32>) -> Vec<i32> {
        
        let n = nums.len();
        let mut dp = vec![vec![0; n]; 32];
        for i in 0..n {
            dp[0][i] = nums[i];
        }
        for i in 1..32 {
            for j in 0..n {
                if j + (1 << i) > n {
                    break;
                }
                dp[i][j] = dp[i - 1][j] | dp[i - 1][j + (1 << (i - 1))];
            }
        }
        let mut ans = vec![0; n];
        for i in 0..n {
            let mut l = 0;
            let mut r = n - i;
            while l < r {
                let mid = (l + r) / 2;
                if dp[31 - mid.leading_zeros() as usize][i] == (1 << 31) - 1 {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            ans[i] = l as i32;
        }
        ans
    }
}