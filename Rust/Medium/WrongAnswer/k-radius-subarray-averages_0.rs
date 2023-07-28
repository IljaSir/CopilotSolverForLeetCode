impl Solution {
    pub fn get_averages(nums: Vec<i32>, k: i32) -> Vec<i32> {
        
        let n = nums.len();
        let mut res = vec![-1; n];
        let mut sum = 0;
        for i in 0..n {
            if i <= k as usize {
                sum += nums[i];
                if i == k as usize {
                    res[i - k as usize] = sum / (k + 1);
                }
            } else {
                sum += nums[i] - nums[i - k as usize - 1];
                res[i - k as usize] = sum / (k + k + 1);
            }
        }
        res
    }
}