impl Solution {
    pub fn find_max_average(nums: Vec<i32>, k: i32) -> f64 {
        
        let mut sum = 0;
        let mut max = 0;
        let k = k as usize;
        for i in 0..k {
            sum += nums[i];
        }
        max = sum;
        for i in k..nums.len() {
            sum += nums[i];
            sum -= nums[i - k];
            max = max.max(sum);
        }
        max as f64 / k as f64
    }
}