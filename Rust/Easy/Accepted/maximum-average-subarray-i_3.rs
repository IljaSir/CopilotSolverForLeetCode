impl Solution {
    pub fn find_max_average(nums: Vec<i32>, k: i32) -> f64 {
        
        let mut sum = 0;
        let k = k as usize;
        for i in 0..k {
            sum += nums[i];
        }
        let mut max_sum = sum;
        for i in k..nums.len() {
            sum += nums[i];
            sum -= nums[i - k];
            max_sum = max_sum.max(sum);
        }
        max_sum as f64 / k as f64
    }
}