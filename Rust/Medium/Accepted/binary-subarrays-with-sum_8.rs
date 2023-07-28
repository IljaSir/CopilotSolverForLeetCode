impl Solution {
    pub fn num_subarrays_with_sum(nums: Vec<i32>, goal: i32) -> i32 {
        
        let mut sum = 0;
        let mut map = std::collections::HashMap::new();
        let mut count = 0;
        for num in nums {
            map.entry(sum).and_modify(|v| *v += 1).or_insert(1);
            sum += num;
            count += map.get(&(sum - goal)).cloned().unwrap_or(0);
        }
        count
    }
}