impl Solution {
    pub fn maximum_difference(nums: Vec<i32>) -> i32 {
        
        let mut res = -1;
        let mut min = nums[0];
        for i in 1..nums.len() {
            if nums[i] > min {
                res = res.max(nums[i] - min);
            } else {
                min = nums[i];
            }
        }
        res
    }
}