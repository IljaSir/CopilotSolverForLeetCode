impl Solution {
    pub fn pivot_index(nums: Vec<i32>) -> i32 {
        
        let mut left = 0;
        let mut right = nums.iter().sum::<i32>();
        for (i, n) in nums.iter().enumerate() {
            if i > 0 {
                left += nums[i - 1];
            }
            right -= n;
            if left == right {
                return i as i32;
            }
        }
        -1
    }
}