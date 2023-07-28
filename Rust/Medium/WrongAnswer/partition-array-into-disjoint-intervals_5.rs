impl Solution {
    pub fn partition_disjoint(nums: Vec<i32>) -> i32 {
        
        let mut left_max = nums[0];
        let mut right_min = nums[0];
        let mut right_min_index = 0;
        let mut i = 1;
        while i < nums.len() {
            if nums[i] < right_min {
                right_min = nums[i];
                right_min_index = i;
            }
            if nums[i] > left_max {
                left_max = nums[i];
            }
            if nums[i] < left_max && i > right_min_index {
                left_max = right_min;
                right_min_index = i;
            }
            i += 1;
        }
        (right_min_index + 1) as i32
    }
}