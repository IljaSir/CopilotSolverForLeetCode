impl Solution {
    pub fn rearrange_array(nums: Vec<i32>) -> Vec<i32> {
        
        let mut nums = nums;
        nums.sort();
        let mut res = Vec::new();
        let n = nums.len();
        for i in 0..n/2 {
            res.push(nums[i]);
            res.push(nums[n/2+i]);
        }
        res
    }
}