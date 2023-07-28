impl Solution {
    pub fn max_ascending_sum(nums: Vec<i32>) -> i32 {
        
        let mut max = 0;
        let mut sum = 0;
        for i in 0..nums.len() {
            if i == 0 {
                sum = nums[i];
                max = sum;
            } else {
                if nums[i] > nums[i-1] {
                    sum += nums[i];
                } else {
                    sum = nums[i];
                }
                if sum > max {
                    max = sum;
                }
            }
        }
        max
    }
}