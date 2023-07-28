impl Solution {
    pub fn min_cost(nums: Vec<i32>, cost: Vec<i32>) -> i64 {
        
        let mut result = 0;
        let mut i = 1;
        while i < nums.len() {
            if nums[i] == nums[i - 1] {
                if cost[i] > cost[i - 1] {
                    result += cost[i - 1] as i64;
                    cost[i] = cost[i - 1];
                } else {
                    result += cost[i] as i64;
                }
            }
            i += 1;
        }
        result
    }
}