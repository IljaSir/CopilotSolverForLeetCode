impl Solution {
    pub fn can_reorder_doubled(arr: Vec<i32>) -> bool {
        
        let mut arr = arr;
        arr.sort();
        let mut counts = std::collections::HashMap::new();
        for &n in &arr {
            *counts.entry(n).or_insert(0) += 1;
        }
        for &n in &arr {
            if let Some(c) = counts.get_mut(&n) {
                if *c == 0 {
                    continue;
                }
                let target = if n < 0 { n / 2 } else { n * 2 };
                if let Some(c2) = counts.get_mut(&target) {
                    if *c2 > 0 {
                        *c -= 1;
                        *c2 -= 1;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        true
    }
}