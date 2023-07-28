impl Solution {
    pub fn maximum_top(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut nums = nums;
        let mut k = k;
        nums.sort_unstable();
        let mut i = 0;
        let mut n = nums.len();
        while i < n && k >= nums[i] {
            k -= nums[i];
            i += 1;
        }
        if i < n {
            nums[i] - k
        } else {
            -1
        }
    }
}