impl Solution {
    pub fn min_cost(nums: Vec<i32>, cost: Vec<i32>) -> i64 {
        
        let mut sum = 0;
        let mut max = 0;
        for i in 1..nums.len() {
            if nums[i-1] == nums[i] {
                sum += cost[i-1];
                max = max.max(cost[i-1]);
            } else {
                sum += max;
                max = 0;
            }
        }
        sum += max;
        sum
    }
}