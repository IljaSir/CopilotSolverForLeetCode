impl Solution {
    pub fn max_operations(nums: Vec<i32>, k: i32) -> i32 {
        
        use std::collections::HashMap;
        let mut map = HashMap::new();
        for num in nums {
            *map.entry(num).or_insert(0) += 1;
        }
        let mut res = 0;
        for (num, count) in map {
            if let Some(other_count) = map.get(&(k - num)) {
                if num == k - num {
                    res += count / 2;
                } else {
                    res += std::cmp::min(count, *other_count);
                }
            }
        }
        res
    }
}