impl Solution {
    pub fn find_middle_index(nums: Vec<i32>) -> i32 {
        
        let mut left_sum = 0;
        let mut right_sum = nums.iter().sum();
        for (index, num) in nums.iter().enumerate() {
            right_sum -= num;
            if left_sum == right_sum {
                return index as i32;
            }
            left_sum += num;
        }
        -1
    }
}