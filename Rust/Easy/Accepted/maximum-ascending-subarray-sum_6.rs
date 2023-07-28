impl Solution {
    pub fn max_ascending_sum(nums: Vec<i32>) -> i32 {
        
        let mut sum = 0;
        let mut max = 0;
        for i in 0..nums.len() {
            if i == 0 {
                sum = nums[i];
            } else {
                if nums[i] > nums[i - 1] {
                    sum += nums[i];
                } else {
                    sum = nums[i];
                }
            }
            max = max.max(sum);
        }
        max
    }
}