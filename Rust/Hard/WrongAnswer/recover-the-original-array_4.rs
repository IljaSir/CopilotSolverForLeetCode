impl Solution {
    pub fn recover_array(nums: Vec<i32>) -> Vec<i32> {
        
        let mut nums = nums;
        nums.sort();
        let n = nums.len();
        let k = (nums[n/2] - nums[n/2-1]).abs();
        let mut res = Vec::new();
        for i in 0..n/2 {
            res.push(nums[i] + k);
        }
        res
    }
}