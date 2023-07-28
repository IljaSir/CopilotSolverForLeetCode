impl Solution {
    pub fn get_averages(nums: Vec<i32>, k: i32) -> Vec<i32> {
        
        let mut res = vec![-1; nums.len()];
        let mut sum = 0;
        for i in 0..nums.len() {
            sum += nums[i];
            if i >= k as usize {
                sum -= nums[i - k as usize];
            }
            if i >= k as usize - 1 {
                res[i - k as usize + 1] = sum / k;
            }
        }
        res
    }
}