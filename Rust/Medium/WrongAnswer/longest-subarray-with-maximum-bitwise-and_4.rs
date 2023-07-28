impl Solution {
    pub fn longest_subarray(nums: Vec<i32>) -> i32 {
        
        let mut ans = 0;
        let mut max = 0;
        for i in 0..nums.len() {
            max &= nums[i];
            max = std::cmp::max(max, nums[i]);
            ans = std::cmp::max(ans, max & (max - 1));
        }
        for i in 0..nums.len() {
            if (nums[i] & ans) == ans {
                return (nums.len() - i) as i32;
            }
        }
        0
    }
}