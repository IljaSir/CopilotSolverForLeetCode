impl Solution {
    pub fn find_lucky(arr: Vec<i32>) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        for i in arr {
            *map.entry(i).or_insert(0) += 1;
        }
        let mut max = -1;
        for (key, value) in map {
            if key == value {
                max = std::cmp::max(max, key);
            }
        }
        max
    }
}