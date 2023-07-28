impl Solution {
    pub fn find_lhs(nums: Vec<i32>) -> i32 {
        
        use std::collections::HashMap;
        let mut map: HashMap<i32, i32> = HashMap::new();
        for num in nums {
            *map.entry(num).or_insert(0) += 1;
        }
        let mut max = 0;
        for (key, value) in map.iter() {
            if map.contains_key(&(key + 1)) {
                max = max.max(value + map.get(&(key + 1)).unwrap());
            }
        }
        max
    }
}