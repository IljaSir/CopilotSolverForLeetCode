impl Solution {
    pub fn num_subseq(nums: Vec<i32>, target: i32) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut left = 0;
        let mut right = nums.len() - 1;
        let mut result = 0;
        let mut mod_num = 1_000_000_007;
        while left <= right {
            if nums[left] + nums[right] <= target {
                result += 1 << (right - left) % mod_num;
                result %= mod_num;
                left += 1;
            } else {
                right -= 1;
            }
        }
        result
    }
}