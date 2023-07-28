impl Solution {
    pub fn partition_disjoint(nums: Vec<i32>) -> i32 {
        
        let mut max_left = nums[0];
        let mut max = nums[0];
        let mut ans = 1;
        for i in 1..nums.len() {
            max = max.max(nums[i]);
            if nums[i] < max_left {
                max_left = max;
                ans = i + 1;
            }
        }
        ans as i32
    }
}