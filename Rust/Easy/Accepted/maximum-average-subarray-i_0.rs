impl Solution {
    pub fn find_max_average(nums: Vec<i32>, k: i32) -> f64 {
        
        let k = k as usize;
        let mut sum = 0;
        for i in 0..k {
            sum += nums[i];
        }
        let mut max = sum;
        for i in k..nums.len() {
            sum = sum - nums[i - k] + nums[i];
            if sum > max {
                max = sum;
            }
        }
        max as f64 / k as f64
    }
}