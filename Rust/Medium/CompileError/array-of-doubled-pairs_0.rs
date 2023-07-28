impl Solution {
    pub fn can_reorder_doubled(arr: Vec<i32>) -> bool {
        
        let mut arr = arr;
        arr.sort();
        let mut map = std::collections::HashMap::new();
        for i in 0..arr.len() {
            *map.entry(arr[i]).or_insert(0) += 1;
        }
        for i in 0..arr.len() {
            if let Some(v) = map.get_mut(&arr[i]) {
                if *v > 0 {
                    let target = arr[i] * 2;
                    if let Some(v2) = map.get_mut(&target) {
                        if *v2 > 0 {
                            *v -= 1;
                            *v2 -= 1;
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
            }
        }
        true
    }
}