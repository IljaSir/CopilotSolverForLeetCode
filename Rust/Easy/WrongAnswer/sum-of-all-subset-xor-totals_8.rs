impl Solution {
    pub fn subset_xor_sum(nums: Vec<i32>) -> i32 {
        
        let mut ans = 0;
        let mut m = 1;
        for i in 0..nums.len() {
            ans += m * nums[i];
            m *= 2;
        }
        ans
    }
}