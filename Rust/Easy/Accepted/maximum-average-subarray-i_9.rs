impl Solution {
    pub fn find_max_average(nums: Vec<i32>, k: i32) -> f64 {
        
        let mut max_sum = nums[..k as usize].iter().sum::<i32>();
        let mut curr_sum = max_sum;
        for i in k as usize..nums.len() {
            curr_sum = curr_sum - nums[i-k as usize] + nums[i];
            max_sum = std::cmp::max(max_sum, curr_sum);
        }
        max_sum as f64 / k as f64
    }
}