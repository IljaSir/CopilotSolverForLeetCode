impl Solution {
    pub fn min_moves2(nums: Vec<i32>) -> i32 {
        

        let mut nums = nums;
        nums.sort();
        let n = nums.len();
        let mut sum = 0;
        for i in 0..n {
            sum += (nums[i] - nums[n / 2]).abs();
        }
        sum
    }
}