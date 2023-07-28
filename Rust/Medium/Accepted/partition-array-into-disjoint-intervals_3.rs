impl Solution {
    pub fn partition_disjoint(nums: Vec<i32>) -> i32 {
        
        let mut max = nums[0];
        let mut left_max = nums[0];
        let mut res = 0;
        for i in 1..nums.len() {
            if nums[i] < left_max {
                res = i;
                left_max = max;
            } else {
                max = max.max(nums[i]);
            }
        }
        res as i32 + 1
    }
}