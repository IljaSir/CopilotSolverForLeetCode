impl Solution {
    pub fn minimum_deletions(nums: Vec<i32>) -> i32 {
        
        let mut min = nums[0];
        let mut max = nums[0];
        let mut min_index = 0;
        let mut max_index = 0;
        for i in 1..nums.len() {
            if nums[i] < min {
                min = nums[i];
                min_index = i;
            }
            if nums[i] > max {
                max = nums[i];
                max_index = i;
            }
        }
        if min_index < max_index {
            min_index as i32 + (nums.len() - 1 - max_index) as i32
        } else {
            min_index as i32 + (nums.len() - 2 - max_index) as i32
        }
    }
}