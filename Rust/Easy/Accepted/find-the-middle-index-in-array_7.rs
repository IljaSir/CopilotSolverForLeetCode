impl Solution {
    pub fn find_middle_index(nums: Vec<i32>) -> i32 {
        
        let mut sum = 0;
        for num in nums.iter() {
            sum += num;
        }
        let mut left = 0;
        for i in 0..nums.len() {
            if left == sum - left - nums[i] {
                return i as i32;
            }
            left += nums[i];
        }
        -1
    }
}