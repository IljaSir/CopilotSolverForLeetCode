impl Solution {
    pub fn minimum_deletions(nums: Vec<i32>) -> i32 {
        
        let mut min = nums[0];
        let mut max = nums[0];
        let mut min_count = 0;
        let mut max_count = 0;
        for i in 0..nums.len() {
            if nums[i] < min {
                min = nums[i];
                min_count = 1;
            } else if nums[i] == min {
                min_count += 1;
            }
            if nums[i] > max {
                max = nums[i];
                max_count = 1;
            } else if nums[i] == max {
                max_count += 1;
            }
        }
        (nums.len() - min_count - max_count) as i32
    }
}