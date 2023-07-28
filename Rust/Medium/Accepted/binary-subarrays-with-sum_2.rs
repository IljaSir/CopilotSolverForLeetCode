impl Solution {
    pub fn num_subarrays_with_sum(nums: Vec<i32>, goal: i32) -> i32 {
        
        let mut sum = 0;
        let mut map = std::collections::HashMap::new();
        let mut res = 0;
        for i in 0..nums.len() {
            sum += nums[i];
            if sum == goal {
                res += 1;
            }
            if map.contains_key(&(sum - goal)) {
                res += map[&(sum - goal)];
            }
            *map.entry(sum).or_insert(0) += 1;
        }
        res
    }
}