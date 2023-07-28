impl Solution {
    pub fn minimize_sum(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let n = nums.len();
        let mut res = nums[n-1] - nums[0];
        for i in 0..n-2 {
            res = res.min(nums[n-1] - nums[i+1] - nums[i]);
            res = res.min(nums[n-2] - nums[i] - nums[i+1]);
        }
        res
    }
}