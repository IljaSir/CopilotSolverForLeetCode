impl Solution {
    pub fn find_lhs(nums: Vec<i32>) -> i32 {
        
        use std::collections::HashMap;
        let mut map = HashMap::new();
        for n in nums.iter() {
            *map.entry(n).or_insert(0) += 1;
        }
        let mut result = 0;
        for (n, c) in map.iter() {
            if let Some(c2) = map.get(&(n+1)) {
                result = result.max(c+c2);
            }
        }
        result
    }
}