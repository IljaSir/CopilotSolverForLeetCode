impl Solution {
    pub fn can_reorder_doubled(arr: Vec<i32>) -> bool {
        
        let mut arr = arr;
        arr.sort_unstable_by(|a, b| a.abs().cmp(&b.abs()));
        let mut map = std::collections::HashMap::new();
        for x in arr {
            let count = map.entry(x).or_insert(0);
            *count += 1;
        }
        for x in arr {
            if let Some(count) = map.get_mut(&x) {
                if *count > 0 {
                    let count2 = map.entry(x * 2).or_insert(0);
                    if *count2 > 0 {
                        *count -= 1;
                        *count2 -= 1;
                    } else {
                        return false;
                    }
                }
            }
        }
        true
    }
}