impl Solution {
    pub fn max_frequency(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let (mut i, mut j, mut res, mut sum) = (0, 0, 1, 0);
        while j < nums.len() {
            sum += nums[j];
            while nums[j] * (j - i + 1) - sum > k {
                sum -= nums[i];
                i += 1;
            }
            res = res.max(j - i + 1);
            j += 1;
        }
        res as i32
    }
}