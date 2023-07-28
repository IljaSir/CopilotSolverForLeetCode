impl Solution {
    pub fn max_frequency(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut i = 0;
        let mut j = 0;
        let mut res = 1;
        let mut sum = 0;
        while j < nums.len() {
            sum += (j - i) as i32 * (nums[j] - nums[j - 1]);
            while sum > k {
                sum -= nums[j] - nums[i];
                i += 1;
            }
            res = res.max(j - i + 1);
            j += 1;
        }
        res as i32
    }
}