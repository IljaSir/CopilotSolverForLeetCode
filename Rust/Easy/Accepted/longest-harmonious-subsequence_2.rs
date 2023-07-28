impl Solution {
    pub fn find_lhs(nums: Vec<i32>) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        for n in nums {
            *map.entry(n).or_insert(0) += 1;
        }
        let mut max = 0;
        for (k, v) in map.iter() {
            if map.contains_key(&(k + 1)) {
                max = std::cmp::max(max, v + map[&(k + 1)]);
            }
        }
        max
    }
}