impl Solution {
    pub fn maximum_gap(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut max_gap = 0;
        for i in 1..nums.len() {
            max_gap = max_gap.max(nums[i] - nums[i-1]);
        }
        max_gap
    }
}