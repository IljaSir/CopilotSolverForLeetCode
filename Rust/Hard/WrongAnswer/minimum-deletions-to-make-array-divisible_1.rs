impl Solution {
    pub fn min_operations(nums: Vec<i32>, nums_divide: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut nums_divide = nums_divide;
        nums_divide.sort();
        let mut i = 0;
        let mut j = 0;
        let mut res = 0;
        while i < nums.len() && j < nums_divide.len() {
            if nums_divide[j] % nums[i] == 0 {
                j += 1;
            } else {
                res += 1;
                i += 1;
            }
        }
        if j < nums_divide.len() {
            return -1;
        }
        res as i32
    }
}