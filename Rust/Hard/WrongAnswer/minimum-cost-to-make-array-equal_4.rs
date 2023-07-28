impl Solution {
    pub fn min_cost(nums: Vec<i32>, cost: Vec<i32>) -> i64 {
        
        let mut sum = 0;
        let mut max = 0;
        let mut prev = nums[0];
        for i in 0..nums.len() {
            if nums[i] == prev {
                max = max.max(cost[i]);
                sum += cost[i];
            } else {
                sum -= max;
                max = cost[i];
                prev = nums[i];
            }
        }
        sum as i64
    }
}