impl Solution {
    pub fn min_operations(nums: Vec<i32>, nums_divide: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        let mut nums_divide = nums_divide;
        nums.sort();
        let mut res = -1;
        for i in 0..nums_divide.len() {
            if nums_divide[i] % nums[0] != 0 {
                return -1;
            }
            nums_divide[i] /= nums[0];
            if res == -1 || res > nums_divide[i] {
                res = nums_divide[i];
            }
        }
        res
    }
}