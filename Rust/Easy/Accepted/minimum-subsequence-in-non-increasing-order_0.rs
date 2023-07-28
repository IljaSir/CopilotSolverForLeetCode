impl Solution {
    pub fn min_subsequence(nums: Vec<i32>) -> Vec<i32> {
        
        let mut nums = nums;
        nums.sort();
        let mut sum = 0;
        for i in 0..nums.len() {
            sum += nums[i];
        }
        let mut ret = vec![];
        let mut temp = 0;
        for i in (0..nums.len()).rev() {
            ret.push(nums[i]);
            temp += nums[i];
            if temp > sum - temp {
                break;
            }
        }
        ret
    }
}