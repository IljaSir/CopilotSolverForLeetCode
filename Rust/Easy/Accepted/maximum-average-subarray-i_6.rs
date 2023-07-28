impl Solution {
    pub fn find_max_average(nums: Vec<i32>, k: i32) -> f64 {
        
        let k = k as usize;
        let mut sum = nums[0..k].iter().sum::<i32>() as f64;
        let mut res = sum / k as f64;
        for i in k..nums.len() {
            sum += nums[i] as f64 - nums[i - k] as f64;
            res = res.max(sum / k as f64);
        }
        res
    }
}