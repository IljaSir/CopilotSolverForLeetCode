impl Solution {
    pub fn repeated_n_times(nums: Vec<i32>) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        for i in nums {
            *map.entry(i).or_insert(0) += 1;
        }
        for (k, v) in map {
            if v == nums.len() / 2 {
                return k;
            }
        }
        return 0;
    }
}