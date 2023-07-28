impl Solution {
    pub fn maximum_product(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let n = nums.len();
        let mut ans = std::i32::MIN;
        ans = ans.max(nums[0] * nums[1] * nums[n - 1]);
        ans = ans.max(nums[n - 1] * nums[n - 2] * nums[n - 3]);
        ans
    }
}