impl Solution {
    pub fn min_cost(nums: Vec<i32>, cost: Vec<i32>) -> i64 {
        
        let mut sum = 0;
        let mut i = 0;
        while i < nums.len() {
            let mut j = i + 1;
            while j < nums.len() && nums[j] == nums[i] {
                j += 1;
            }
            if j > i + 1 {
                let mut max = 0;
                let mut max_idx = 0;
                for k in i..j {
                    if cost[k] > max {
                        max = cost[k];
                        max_idx = k;
                    }
                }
                for k in i..j {
                    if k != max_idx {
                        sum += cost[k];
                    }
                }
            }
            i = j;
        }
        sum
    }
}