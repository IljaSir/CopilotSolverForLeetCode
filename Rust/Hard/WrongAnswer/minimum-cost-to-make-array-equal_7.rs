impl Solution {
    pub fn min_cost(nums: Vec<i32>, cost: Vec<i32>) -> i64 {
        
        let mut cost = cost;
        let mut nums = nums;
        let mut sum = 0;
        for i in 1..nums.len() {
            if nums[i] == nums[i-1] {
                if cost[i] < cost[i-1] {
                    sum += cost[i] as i64;
                    cost[i] = cost[i-1];
                } else {
                    sum += cost[i-1] as i64;
                }
            }
        }
        sum
    }
}