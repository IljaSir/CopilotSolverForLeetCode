impl Solution {
    pub fn intersect(nums1: Vec<i32>, nums2: Vec<i32>) -> Vec<i32> {
        
        let mut map = std::collections::HashMap::new();
        nums1.into_iter().for_each(|x| *map.entry(x).or_insert(0) += 1);
        nums2.into_iter().filter(|&x| {
            if let Some(v) = map.get_mut(&x) {
                if *v > 0 {
                    *v -= 1;
                    return true;
                }
            }
            false
        }).collect()
    }
}