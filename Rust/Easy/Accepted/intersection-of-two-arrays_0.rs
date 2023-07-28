impl Solution {
    pub fn intersection(nums1: Vec<i32>, nums2: Vec<i32>) -> Vec<i32> {
        
        use std::collections::HashSet;
        let mut set1 = HashSet::new();
        let mut set2 = HashSet::new();
        for num in nums1 {
            set1.insert(num);
        }
        for num in nums2 {
            set2.insert(num);
        }
        let mut ans = Vec::new();
        for num in set1 {
            if set2.contains(&num) {
                ans.push(num);
            }
        }
        ans
    }
}