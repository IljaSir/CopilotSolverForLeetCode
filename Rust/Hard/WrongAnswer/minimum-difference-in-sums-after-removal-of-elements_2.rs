impl Solution {
    pub fn minimum_difference(nums: Vec<i32>) -> i64 {
        
        let mut nums = nums;
        nums.sort();
        let n = nums.len();
        let mut res = i64::MAX;
        for i in 0..n/2 {
            res = res.min((nums[i+n/2] - nums[i]) as i64);
        }
        res
    }
}