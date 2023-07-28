impl Solution {
    pub fn two_out_of_three(nums1: Vec<i32>, nums2: Vec<i32>, nums3: Vec<i32>) -> Vec<i32> {
        
        let mut set1 = std::collections::HashSet::new();
        let mut set2 = std::collections::HashSet::new();
        let mut set3 = std::collections::HashSet::new();
        
        for n in nums1 {
            set1.insert(n);
        }
        for n in nums2 {
            set2.insert(n);
        }
        for n in nums3 {
            set3.insert(n);
        }
        
        let mut result = std::collections::HashSet::new();
        for n in set1 {
            if set2.contains(&n) || set3.contains(&n) {
                result.insert(n);
            }
        }
        for n in set2 {
            if set3.contains(&n) {
                result.insert(n);
            }
        }
        result.into_iter().collect()
    }
}