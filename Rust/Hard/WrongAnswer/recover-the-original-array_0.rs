impl Solution {
    pub fn recover_array(nums: Vec<i32>) -> Vec<i32> {
        
        let n = nums.len() / 2;
        let mut nums = nums;
        nums.sort();
        let mut res = vec![0; n];
        for i in 0..n {
            res[i] = nums[i] + nums[2 * n - i - 1];
            res[i] /= 2;
        }
        res
    }
}