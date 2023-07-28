impl Solution {
    pub fn can_arrange(arr: Vec<i32>, k: i32) -> bool {
        
        let n = arr.len();
        let mut arr = arr;
        arr.sort();
        let mut map = std::collections::HashMap::new();
        for i in 0..n {
            let remainder = arr[i] % k;
            if remainder < 0 {
                let remainder = remainder + k;
            }
            if remainder == 0 {
                continue;
            }
            if let Some(x) = map.get_mut(&(k - remainder)) {
                if *x > 0 {
                    *x -= 1;
                    continue;
                }
            }
            *map.entry(remainder).or_insert(0) += 1;
        }
        for (_, v) in map {
            if v > 0 {
                return false;
            }
        }
        true
    }
}