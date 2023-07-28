impl Solution {
    pub fn min_subsequence(nums: Vec<i32>) -> Vec<i32> {
        
        let mut nums = nums;
        let mut sum = 0;
        for i in &nums {
            sum += i;
        }
        let mut half = 0;
        nums.sort();
        let mut res = Vec::new();
        for i in (0..nums.len()).rev() {
            half += nums[i];
            res.push(nums[i]);
            if half > sum - half {
                break;
            }
        }
        res
    }
}