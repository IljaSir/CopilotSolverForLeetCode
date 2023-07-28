impl Solution {
    pub fn get_averages(nums: Vec<i32>, k: i32) -> Vec<i32> {
        
        let mut avgs = vec![-1; nums.len()];
        let mut sum = 0;
        let mut count = 0;
        let k = k as usize;
        for i in 0..nums.len() {
            if i <= k {
                sum += nums[i];
                count += 1;
            }
            if i > k {
                sum += nums[i] - nums[i - k - 1];
            }
            if i >= k {
                avgs[i - k] = sum / count as i32;
            }
        }
        avgs
    }
}