impl Solution {
    pub fn num_subarrays_with_sum(nums: Vec<i32>, goal: i32) -> i32 {
        
        let mut sum = 0;
        let mut count = 0;
        let mut map = std::collections::HashMap::new();
        for i in 0..nums.len() {
            sum += nums[i];
            if sum == goal {
                count += 1;
            }
            if let Some(c) = map.get(&(sum - goal)) {
                count += c;
            }
            *map.entry(sum).or_insert(0) += 1;
        }
        count
    }
}