impl Solution {
    pub fn maximum_difference(nums: Vec<i32>) -> i32 {
        
        let mut min = std::i32::MAX;
        let mut max = -1;
        for i in 1..nums.len() {
            if nums[i] > nums[i - 1] {
                min = min.min(nums[i - 1]);
                max = max.max(nums[i]);
            }
        }
        if max == -1 {
            return -1;
        }
        max - min
    }
}