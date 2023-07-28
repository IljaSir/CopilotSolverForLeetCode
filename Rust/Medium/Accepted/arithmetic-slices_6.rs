impl Solution {
    pub fn number_of_arithmetic_slices(nums: Vec<i32>) -> i32 {
        

        let mut last = 0;
        let mut result = 0;
        for i in 2..nums.len() {
            if nums[i] - nums[i-1] == nums[i-1] - nums[i-2] {
                last += 1;
                result += last;
            } else {
                last = 0;
            }
        }
        result
    }
}