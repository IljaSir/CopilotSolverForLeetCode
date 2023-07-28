impl Solution {
    pub fn minimum_average_difference(nums: Vec<i32>) -> i32 {
        
        let mut sum = 0;
        let mut min = 100000;
        let mut min_index = 0;
        for i in 0..nums.len() {
            sum += nums[i];
            if i >= 5 {
                sum -= nums[i - 5];
            }
            if i >= 4 {
                let avg = sum / 5;
                let diff = (nums[i - 4] - avg).abs();
                if diff < min {
                    min = diff;
                    min_index = i - 4;
                }
            }
        }
        min_index as i32
    }
}