impl Solution {
    pub fn two_out_of_three(nums1: Vec<i32>, nums2: Vec<i32>, nums3: Vec<i32>) -> Vec<i32> {
        
        let mut res = Vec::new();
        let mut map = std::collections::HashMap::new();
        for i in nums1 {
            if !map.contains_key(&i) {
                map.insert(i, 1);
            }
        }
        for i in nums2 {
            if map.contains_key(&i) {
                map.insert(i, 2);
            } else {
                map.insert(i, 1);
            }
        }
        for i in nums3 {
            if map.contains_key(&i) {
                map.insert(i, 2);
            } else {
                map.insert(i, 1);
            }
        }
        for (k, v) in map {
            if v == 2 {
                res.push(k);
            }
        }
        res
    }
}