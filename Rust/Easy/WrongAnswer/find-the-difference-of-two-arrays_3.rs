impl Solution {
    pub fn find_difference(nums1: Vec<i32>, nums2: Vec<i32>) -> Vec<Vec<i32>> {
        
        let mut diff1 = Vec::new();
        let mut diff2 = Vec::new();
        let mut set1 = std::collections::HashSet::new();
        let mut set2 = std::collections::HashSet::new();
        for num in nums1 {
            if set2.contains(&num) {
                set2.remove(&num);
            } else {
                set1.insert(num);
            }
        }
        for num in nums2 {
            if set1.contains(&num) {
                set1.remove(&num);
            } else {
                set2.insert(num);
            }
        }
        for num in set1 {
            diff1.push(num);
        }
        for num in set2 {
            diff2.push(num);
        }
        vec![diff1, diff2]
    }
}