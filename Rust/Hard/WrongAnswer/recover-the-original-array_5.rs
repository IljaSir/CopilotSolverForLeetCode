impl Solution {
    pub fn recover_array(nums: Vec<i32>) -> Vec<i32> {
        
        let mut nums = nums;
        nums.sort();
        let mut result = vec![0; nums.len()/2];
        let n = nums.len();
        for i in 0..n/2 {
            result[i] = (nums[i] + nums[n-1-i])/2;
        }
        result
    }
}