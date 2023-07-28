impl Solution {
    pub fn min_cost(nums: Vec<i32>, cost: Vec<i32>) -> i64 {
        
        let mut ans = 0;
        let mut i = 0;
        while i < nums.len() {
            let mut j = i + 1;
            let mut max_cost = cost[i];
            let mut sum = cost[i];
            while j < nums.len() && nums[j] == nums[i] {
                max_cost = max_cost.max(cost[j]);
                sum += cost[j];
                j += 1;
            }
            ans += sum - max_cost;
            i = j;
        }
        ans
    }
}