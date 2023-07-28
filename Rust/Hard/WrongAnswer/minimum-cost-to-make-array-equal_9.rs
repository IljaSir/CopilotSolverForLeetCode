impl Solution {
    pub fn min_cost(nums: Vec<i32>, cost: Vec<i32>) -> i64 {
        
        let mut ans = 0i64;
        let mut i = 0;
        while i < nums.len() {
            let mut max = 0i64;
            let mut sum = 0i64;
            let mut j = i;
            while j < nums.len() && nums[i] == nums[j] {
                max = max.max(cost[j] as i64);
                sum += cost[j] as i64;
                j += 1;
            }
            ans += sum - max;
            i = j;
        }
        ans
    }
}