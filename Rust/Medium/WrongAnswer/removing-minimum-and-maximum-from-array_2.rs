impl Solution {
    pub fn minimum_deletions(nums: Vec<i32>) -> i32 {
        
        let mut min = nums[0];
        let mut max = nums[0];
        let mut min_count = 0;
        let mut max_count = 0;
        for i in 1..nums.len() {
            if nums[i] < min {
                min = nums[i];
                min_count = i as i32;
            }
            if nums[i] > max {
                max = nums[i];
                max_count = i as i32;
            }
        }
        let len = nums.len() as i32;
        min_count.min(len - 1 - max_count)
    }
}