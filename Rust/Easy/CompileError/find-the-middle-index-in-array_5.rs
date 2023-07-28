impl Solution {
    pub fn find_middle_index(nums: Vec<i32>) -> i32 {
        
        let mut left = 0;
        let mut right = nums.iter().sum();
        for (i, &num) in nums.iter().enumerate() {
            right -= num;
            if left == right {
                return i as i32;
            }
            left += num;
        }
        return -1;
    }
}