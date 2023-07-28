impl Solution {
    pub fn subset_xor_sum(nums: Vec<i32>) -> i32 {
        
        let mut ans = 0;
        let mut n = nums.len();
        for i in 0..n {
            ans += nums[i] * (1 << n - 1);
        }
        ans
    }
}