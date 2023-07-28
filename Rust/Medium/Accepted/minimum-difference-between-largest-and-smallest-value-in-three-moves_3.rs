impl Solution {
    pub fn min_difference(nums: Vec<i32>) -> i32 {
        
        if nums.len() <= 4 {
            return 0;
        }
        let mut nums = nums;
        nums.sort();
        let n = nums.len();
        let mut ans = i32::max_value();
        for i in 0..4 {
            ans = ans.min(nums[n - 4 + i] - nums[i]);
        }
        ans
    }
}