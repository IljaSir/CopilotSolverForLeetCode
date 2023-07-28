impl Solution {
    pub fn find_lucky(arr: Vec<i32>) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        for i in arr.iter() {
            let count = map.entry(i).or_insert(0);
            *count += 1;
        }
        let mut max = -1;
        for (key, value) in map.iter() {
            if *key == value {
                max = std::cmp::max(max, *key);
            }
        }
        max
    }
}