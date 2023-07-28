impl Solution {
    pub fn get_averages(nums: Vec<i32>, k: i32) -> Vec<i32> {
        
        let mut res = vec![];
        let mut sum = 0;
        let mut n = nums.len();
        for i in 0..n {
            if i > k as usize {
                sum -= nums[i - k as usize - 1];
            }
            if i + k as usize < n {
                sum += nums[i + k as usize];
            }
            if i >= k as usize {
                res.push(sum / (2 * k + 1));
            } else {
                res.push(-1);
            }
        }
        res
    }
}