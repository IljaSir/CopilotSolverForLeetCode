impl Solution {
    pub fn min_subsequence(nums: Vec<i32>) -> Vec<i32> {
        
        let mut nums = nums;
        nums.sort();
        let mut sum = 0;
        for i in &nums {
            sum += i;
        }
        let mut res = vec![];
        let mut sum_sub = 0;
        for i in (0..nums.len()).rev() {
            sum_sub += nums[i];
            res.push(nums[i]);
            if sum_sub > sum - sum_sub {
                break;
            }
        }
        res
    }
}