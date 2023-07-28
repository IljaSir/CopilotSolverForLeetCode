impl Solution {
    pub fn num_subarrays_with_sum(nums: Vec<i32>, goal: i32) -> i32 {
        
        let mut sum = 0;
        let mut count = 0;
        let mut map = std::collections::HashMap::new();
        map.insert(0, 1);
        for i in 0..nums.len() {
            sum += nums[i];
            let diff = sum - goal;
            if map.contains_key(&diff) {
                count += map[&diff];
            }
            *map.entry(sum).or_insert(0) += 1;
        }
        count
    }
}