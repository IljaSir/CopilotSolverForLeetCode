impl Solution {
    pub fn number_of_arithmetic_slices(nums: Vec<i32>) -> i32 {
        

        let mut res = 0;
        let mut cur = 0;
        for i in 2..nums.len() {
            if nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2] {
                cur += 1;
                res += cur;
            } else {
                cur = 0;
            }
        }
        res
    }
}