impl Solution {
    pub fn find_middle_index(nums: Vec<i32>) -> i32 {
        
        let n = nums.len();
        let mut sum = 0;
        for i in 0..n {
            sum += nums[i];
        }
        let mut left = 0;
        for i in 0..n {
            if left == sum - left - nums[i] {
                return i as i32;
            }
            left += nums[i];
        }
        -1
    }
}