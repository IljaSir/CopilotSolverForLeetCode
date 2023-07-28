impl Solution {
    pub fn min_operations(nums: Vec<i32>, nums_divide: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        let mut nums_divide = nums_divide;
        let mut min = i32::MAX;
        for &num in nums.iter() {
            if num < min {
                min = num;
            }
        }
        let mut ans = 0;
        for &num in nums_divide.iter() {
            if num % min != 0 {
                return -1;
            }
            ans += num / min - 1;
        }
        ans
    }
}