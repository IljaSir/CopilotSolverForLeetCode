impl Solution {
    pub fn find_lhs(nums: Vec<i32>) -> i32 {
        
        use std::collections::HashMap;
        let mut map = HashMap::new();
        for num in nums {
            *map.entry(num).or_insert(0) += 1;
        }
        let mut max = 0;
        for (&k, &v) in map.iter() {
            if let Some(&v2) = map.get(&(k + 1)) {
                max = max.max(v + v2);
            }
        }
        max
    }
}