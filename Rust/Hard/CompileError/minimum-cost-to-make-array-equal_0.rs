impl Solution {
    pub fn min_cost(nums: Vec<i32>, cost: Vec<i32>) -> i64 {
        
        let mut res = 0;
        let mut i = 0;
        while i < nums.len() {
            let mut j = i + 1;
            while j < nums.len() && nums[j] == nums[i] {
                j += 1;
            }
            let mut max = 0;
            let mut sum = 0;
            for k in i..j {
                max = max.max(cost[k]);
                sum += cost[k];
            }
            res += sum - max;
            i = j;
        }
        res
    }
}