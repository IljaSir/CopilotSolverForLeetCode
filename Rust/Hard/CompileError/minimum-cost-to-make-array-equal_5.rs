impl Solution {
    pub fn min_cost(nums: Vec<i32>, cost: Vec<i32>) -> i64 {
        
        let mut sum = 0;
        let mut max = 0;
        let mut prev = nums[0];
        for i in 0..nums.len() {
            if prev == nums[i] {
                sum += cost[i];
                max = max.max(cost[i]);
            } else {
                sum -= max;
                max = 0;
                prev = nums[i];
            }
        }
        sum
    }
}