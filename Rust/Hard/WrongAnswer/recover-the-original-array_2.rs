impl Solution {
    pub fn recover_array(nums: Vec<i32>) -> Vec<i32> {
        
        let mut nums = nums;
        nums.sort();
        let n = nums.len() / 2;
        let mut ans = vec![0; n];
        for i in 0..n {
            ans[i] = nums[i] + (nums[i + n] - nums[i]) / 2;
        }
        ans
    }
}