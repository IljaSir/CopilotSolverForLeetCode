impl Solution {
    pub fn two_out_of_three(nums1: Vec<i32>, nums2: Vec<i32>, nums3: Vec<i32>) -> Vec<i32> {
        
        let mut set: std::collections::HashSet<i32> = std::collections::HashSet::new();
        for x in nums1.iter() {
            set.insert(*x);
        }
        for x in nums2.iter() {
            set.insert(*x);
        }
        for x in nums3.iter() {
            set.insert(*x);
        }
        let mut result = Vec::new();
        for x in set.iter() {
            if nums1.contains(x) && nums2.contains(x) {
                result.push(*x);
            } else if nums1.contains(x) && nums3.contains(x) {
                result.push(*x);
            } else if nums2.contains(x) && nums3.contains(x) {
                result.push(*x);
            }
        }
        result
    }
}