impl Solution {
    pub fn min_cost(nums: Vec<i32>, cost: Vec<i32>) -> i64 {
        
        let mut sum = 0;
        let mut i = 0;
        while i < nums.len() {
            let mut j = i + 1;
            let mut max = cost[i];
            let mut max_idx = i;
            while j < nums.len() && nums[j] == nums[i] {
                if cost[j] > max {
                    max = cost[j];
                    max_idx = j;
                }
                j += 1;
            }
            for k in i..j {
                if k != max_idx {
                    sum += cost[k];
                }
            }
            i = j;
        }
        sum
    }
}