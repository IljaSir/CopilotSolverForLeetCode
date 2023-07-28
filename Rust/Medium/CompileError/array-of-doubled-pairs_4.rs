impl Solution {
    pub fn can_reorder_doubled(arr: Vec<i32>) -> bool {
        
        let mut arr = arr;
        arr.sort_unstable_by(|a, b| a.abs().cmp(&b.abs()));
        let mut map = std::collections::HashMap::new();
        for &x in &arr {
            *map.entry(x).or_insert(0) += 1;
        }
        for &x in &arr {
            if let Some(&mut cnt) = map.get_mut(&x) {
                if cnt <= 0 {
                    continue;
                }
                if let Some(&mut cnt2) = map.get_mut(&(x * 2)) {
                    if cnt2 <= 0 {
                        return false;
                    }
                    cnt -= 1;
                    cnt2 -= 1;
                } else {
                    return false;
                }
            }
        }
        true
    }
}