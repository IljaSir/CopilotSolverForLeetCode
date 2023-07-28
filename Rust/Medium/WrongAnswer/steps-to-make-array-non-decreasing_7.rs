impl Solution {
    pub fn total_steps(nums: Vec<i32>) -> i32 {
        
        let mut result = 0;
        let mut last_num = nums[0];
        for num in nums {
            if num < last_num {
                result += 1;
            } else {
                last_num = num;
            }
        }
        result
    }
}