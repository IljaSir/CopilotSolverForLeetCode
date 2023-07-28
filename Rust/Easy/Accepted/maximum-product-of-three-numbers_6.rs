impl Solution {
    pub fn maximum_product(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let n = nums.len();
        let mut ans = nums[n - 1] * nums[n - 2] * nums[n - 3];
        ans = ans.max(nums[0] * nums[1] * nums[n - 1]);
        ans
    }
}