impl Solution {
    pub fn max_frequency(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut l = 0;
        let mut r = 0;
        let mut sum = 0;
        let mut ans = 0;
        while r < nums.len() {
            sum += (nums[r] - nums[l]) * (r - l) as i32;
            while sum > k {
                sum -= nums[r] - nums[l];
                l += 1;
            }
            ans = ans.max(r - l + 1);
            r += 1;
        }
        ans as i32
    }
}