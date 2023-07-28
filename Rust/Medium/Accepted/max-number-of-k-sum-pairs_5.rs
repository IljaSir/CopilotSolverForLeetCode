impl Solution {
    pub fn max_operations(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        let mut res = 0;
        for num in nums {
            if let Some(v) = map.get_mut(&(k - num)) {
                if *v > 0 {
                    *v -= 1;
                    res += 1;
                    continue;
                }
            }
            *map.entry(num).or_insert(0) += 1;
        }
        res
    }
}