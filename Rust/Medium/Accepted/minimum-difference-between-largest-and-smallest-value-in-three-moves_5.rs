impl Solution {
    pub fn min_difference(nums: Vec<i32>) -> i32 {
        
        let n = nums.len();
        if n <= 4 {
            return 0;
        }
        let mut nums = nums;
        nums.sort_unstable();
        let mut diff = std::i32::MAX;
        for i in 0..4 {
            diff = diff.min(nums[n - 4 + i] - nums[i]);
        }
        diff
    }
}