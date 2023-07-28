impl Solution {
    pub fn max_frequency(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut i = 0;
        let mut j = 1;
        let mut k = k;
        let mut res = 1;
        while j < nums.len() {
            k -= nums[j] - nums[j - 1];
            while k < 0 {
                k += nums[j] - nums[i];
                i += 1;
            }
            res = res.max(j - i + 1);
            j += 1;
        }
        res as i32
    }
}