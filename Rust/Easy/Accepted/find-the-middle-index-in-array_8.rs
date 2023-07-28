impl Solution {
    pub fn find_middle_index(nums: Vec<i32>) -> i32 {
        
        let mut sum = nums.iter().sum::<i32>();
        let mut left_sum = 0;
        for (i, &num) in nums.iter().enumerate() {
            if left_sum == sum - left_sum - num {
                return i as i32;
            }
            left_sum += num;
        }
        -1
    }
}