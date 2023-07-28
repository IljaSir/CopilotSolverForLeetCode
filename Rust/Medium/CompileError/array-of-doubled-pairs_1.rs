impl Solution {
    pub fn can_reorder_doubled(arr: Vec<i32>) -> bool {
        
        let mut arr = arr;
        arr.sort_unstable_by(|a, b| a.abs().cmp(&b.abs()));
        let mut map = std::collections::HashMap::new();
        for n in arr {
            *map.entry(n).or_insert(0) += 1;
        }
        for n in arr {
            if let Some(&count) = map.get(&n) {
                if count == 0 {
                    continue;
                }
                let double = n * 2;
                if n == 0 {
                    if count % 2 != 0 {
                        return false;
                    }
                } else if let Some(&count_double) = map.get(&double) {
                    if count_double < count {
                        return false;
                    }
                    map.insert(double, count_double - count);
                } else {
                    return false;
                }
            }
        }
        true
    }
}