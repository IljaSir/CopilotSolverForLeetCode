impl Solution {
    pub fn find_lucky(arr: Vec<i32>) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        for i in arr {
            *map.entry(i).or_insert(0) += 1;
        }
        let mut max = -1;
        for (k, v) in map {
            if k == v {
                max = std::cmp::max(max, k);
            }
        }
        max
    }
}