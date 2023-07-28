impl Solution {
    pub fn min_subsequence(nums: Vec<i32>) -> Vec<i32> {
        
        let mut nums = nums;
        nums.sort_unstable();
        let sum: i32 = nums.iter().sum();
        let mut s = 0;
        let mut i = nums.len();
        while s <= sum - s {
            i -= 1;
            s += nums[i];
        }
        nums[i..].to_vec()
    }
}