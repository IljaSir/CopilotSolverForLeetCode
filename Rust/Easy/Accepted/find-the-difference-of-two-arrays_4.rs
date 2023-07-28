impl Solution {
    pub fn find_difference(nums1: Vec<i32>, nums2: Vec<i32>) -> Vec<Vec<i32>> {
        
        let mut result = vec![vec![], vec![]];
        let mut set1 = std::collections::HashSet::new();
        let mut set2 = std::collections::HashSet::new();
        for n in nums1 {
            set1.insert(n);
        }
        for n in nums2 {
            set2.insert(n);
        }
        for n in set1.difference(&set2) {
            result[0].push(*n);
        }
        for n in set2.difference(&set1) {
            result[1].push(*n);
        }
        result
    }
}