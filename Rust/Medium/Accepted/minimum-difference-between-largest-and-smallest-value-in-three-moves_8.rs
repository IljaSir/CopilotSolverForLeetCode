impl Solution {
    pub fn min_difference(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let n = nums.len();
        if n <= 3 {
            return 0;
        }
        let mut res = (nums[n - 1] - nums[0]) as i64;
        for i in 0..4 {
            res = res.min((nums[n - 4 + i] - nums[i]) as i64);
        }
        res as i32
    }
}