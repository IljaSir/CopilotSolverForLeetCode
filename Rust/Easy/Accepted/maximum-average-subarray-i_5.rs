impl Solution {
    pub fn find_max_average(nums: Vec<i32>, k: i32) -> f64 {
        
        let mut sum = nums.iter().take(k as usize).sum::<i32>() as f64;
        let mut max = sum;
        for i in k as usize..nums.len() {
            sum += nums[i] as f64 - nums[i - k as usize] as f64;
            max = max.max(sum);
        }
        max / k as f64
    }
}