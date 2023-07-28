impl Solution {
    pub fn maximum_top(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut k = k;
        let mut i = nums.len() - 1;
        while i > 0 && k >= nums[i] - nums[i - 1] {
            k -= nums[i] - nums[i - 1];
            i -= 1;
        }
        if k > 0 {
            nums[i] - k
        } else {
            nums[i]
        }
    }
}