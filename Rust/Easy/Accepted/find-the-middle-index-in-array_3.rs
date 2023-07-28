impl Solution {
    pub fn find_middle_index(nums: Vec<i32>) -> i32 {
        
        let mut left = 0;
        let mut right = nums.iter().sum::<i32>();
        for (i, n) in nums.iter().enumerate() {
            right -= n;
            if left == right {
                return i as i32;
            }
            left += n;
        }
        -1
    }
}