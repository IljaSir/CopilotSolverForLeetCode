impl Solution {
    pub fn min_difference(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let n = nums.len();
        let mut ans = nums[n - 1] - nums[0];
        for i in 0..4 {
            ans = ans.min(nums[n - 4 + i] - nums[i]);
        }
        ans
    }
}