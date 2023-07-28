impl Solution {
    pub fn sort_even_odd(nums: Vec<i32>) -> Vec<i32> {
        
        let mut nums = nums;
        nums[1..].sort_by(|a, b| b.cmp(a));
        nums[0..].sort_by(|a, b| a.cmp(b));
        return nums;
    }
}