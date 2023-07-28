impl Solution {
    pub fn min_subsequence(nums: Vec<i32>) -> Vec<i32> {
        
        let mut nums = nums;
        nums.sort();
        let mut sum = 0;
        let mut res = Vec::new();
        for i in 0..nums.len() {
            sum += nums[i];
        }
        let mut cur_sum = 0;
        for i in (0..nums.len()).rev() {
            cur_sum += nums[i];
            res.push(nums[i]);
            if cur_sum > sum - cur_sum {
                break;
            }
        }
        res
    }
}