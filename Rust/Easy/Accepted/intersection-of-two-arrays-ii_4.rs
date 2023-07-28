impl Solution {
    pub fn intersect(nums1: Vec<i32>, nums2: Vec<i32>) -> Vec<i32> {
        
        use std::collections::HashMap;
        let mut map = HashMap::new();
        for n in nums1 {
            *map.entry(n).or_insert(0) += 1;
        }
        let mut res = Vec::new();
        for n in nums2 {
            if let Some(c) = map.get_mut(&n) {
                if *c > 0 {
                    res.push(n);
                    *c -= 1;
                }
            }
        }
        res
    }
}