impl Solution {
    pub fn find_difference(nums1: Vec<i32>, nums2: Vec<i32>) -> Vec<Vec<i32>> {
        
        let mut res = vec![vec![], vec![]];
        let mut map = std::collections::HashMap::new();
        for num in nums1 {
            *map.entry(num).or_insert(0) += 1;
        }
        for num in nums2 {
            *map.entry(num).or_insert(0) -= 1;
        }
        for (k, v) in map {
            if v > 0 {
                res[0].push(k);
            } else if v < 0 {
                res[1].push(k);
            }
        }
        res
    }
}