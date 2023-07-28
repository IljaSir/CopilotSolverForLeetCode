impl Solution {
    pub fn get_averages(nums: Vec<i32>, k: i32) -> Vec<i32> {
        
        let n = nums.len();
        let k = k as usize;
        let mut ans = vec![-1; n];
        let mut sum = 0;
        let mut count = 0;
        for i in 0..n {
            sum += nums[i];
            count += 1;
            if count > k {
                sum -= nums[i - k];
                count -= 1;
            }
            if count == k {
                ans[i - k + 1] = sum / count as i32;
            }
        }
        ans
    }
}