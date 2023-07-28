impl Solution {
    pub fn minimum_average_difference(nums: Vec<i32>) -> i32 {
        
        let mut sum = 0;
        let mut sum2 = 0;
        let mut min = 100000;
        let mut min_index = 0;
        for i in 0..nums.len() {
            sum += nums[i];
            sum2 += nums[nums.len() - 1 - i];
            let a = sum / (i + 1) as i32;
            let b = sum2 / (i + 1) as i32;
            let diff = (a - b).abs();
            if diff < min {
                min = diff;
                min_index = i;
            }
        }
        min_index as i32
    }
}