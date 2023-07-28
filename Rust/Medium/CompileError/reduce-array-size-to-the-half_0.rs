impl Solution {
    pub fn min_set_size(arr: Vec<i32>) -> i32 {
        
        use std::collections::HashMap;
        let mut map: HashMap<i32, i32> = HashMap::new();
        for i in arr {
            let count = map.entry(i).or_insert(0);
            *count += 1;
        }
        let mut v: Vec<i32> = map.values().cloned().collect();
        v.sort_by(|a, b| b.cmp(a));
        let mut sum = 0;
        let mut count = 0;
        for i in v {
            sum += i;
            count += 1;
            if sum >= arr.len() as i32 / 2 {
                return count;
            }
        }
        0
    }
}