impl Solution {
    pub fn max_frequency(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut left = 0;
        let mut right = 0;
        let mut sum = 0;
        let mut ans = 1;
        while right < nums.len() {
            sum += (nums[right] - nums[right - 1]) * (right - left) as i32;
            while sum > k {
                sum -= nums[right] - nums[left];
                left += 1;
            }
            ans = ans.max(right - left + 1);
            right += 1;
        }
        ans as i32
    }
}