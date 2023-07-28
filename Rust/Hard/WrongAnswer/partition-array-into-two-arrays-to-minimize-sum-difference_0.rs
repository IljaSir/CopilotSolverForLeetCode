impl Solution {
    pub fn minimum_difference(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut ans = i32::MAX;
        for i in 0..nums.len() / 2 {
            ans = ans.min(nums[i + nums.len() / 2] - nums[i]);
        }
        ans
    }
}