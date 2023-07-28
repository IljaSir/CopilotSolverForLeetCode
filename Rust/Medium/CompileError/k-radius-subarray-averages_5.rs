impl Solution {
    pub fn get_averages(nums: Vec<i32>, k: i32) -> Vec<i32> {
        
        let mut res = vec![-1; nums.len()];
        let mut sum = 0;
        let mut count = 0;
        for i in 0..nums.len() {
            if i > k as usize {
                sum -= nums[i - k as usize - 1];
                count -= 1;
            }
            if i + k as usize < nums.len() {
                sum += nums[i + k as usize];
                count += 1;
            }
            if count > 0 {
                res[i] = sum / count;
            }
        }
        res
    }
}