impl Solution {
    pub fn get_averages(nums: Vec<i32>, k: i32) -> Vec<i32> {
        
        let mut sum = 0;
        let mut res = vec![-1; nums.len()];
        for i in 0..nums.len() as i32 {
            if i <= k {
                sum += nums[i as usize];
                if i == k {
                    res[i as usize] = sum / (i + 1);
                }
            } else if i >= nums.len() as i32 - k {
                sum -= nums[(i - k - 1) as usize];
                if i == nums.len() as i32 - k {
                    res[i as usize] = sum / (k * 2 + 1);
                }
            } else {
                sum -= nums[(i - k - 1) as usize];
                sum += nums[(i + k) as usize];
                res[i as usize] = sum / (k * 2 + 1);
            }
        }
        res
    }
}