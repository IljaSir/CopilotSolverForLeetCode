impl Solution {
    pub fn intersect(nums1: Vec<i32>, nums2: Vec<i32>) -> Vec<i32> {
        
        use std::collections::HashMap;
        let mut map1 = HashMap::new();
        let mut map2 = HashMap::new();
        for n in &nums1 {
            let count = map1.entry(n).or_insert(0);
            *count += 1;
        }
        for n in &nums2 {
            let count = map2.entry(n).or_insert(0);
            *count += 1;
        }
        let mut res = Vec::new();
        for (k, v) in map1 {
            if let Some(v2) = map2.get(&k) {
                for _ in 0..v.min(*v2) {
                    res.push(*k);
                }
            }
        }
        res
    }
}