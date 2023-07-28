impl Solution {
    pub fn max_frequency(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let (mut i, mut j, mut k, mut max) = (0, 1, k, 1);
        while j < nums.len() {
            k -= nums[j] - nums[j - 1];
            while k < 0 {
                k += nums[j] - nums[i];
                i += 1;
            }
            max = std::cmp::max(max, j - i + 1);
            j += 1;
        }
        max as i32
    }
}