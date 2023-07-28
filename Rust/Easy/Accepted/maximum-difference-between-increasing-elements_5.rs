impl Solution {
    pub fn maximum_difference(nums: Vec<i32>) -> i32 {
        
        let mut max = -1;
        for i in 0..nums.len() {
            for j in i + 1..nums.len() {
                if nums[i] < nums[j] {
                    max = max.max(nums[j] - nums[i]);
                }
            }
        }
        max
    }
}