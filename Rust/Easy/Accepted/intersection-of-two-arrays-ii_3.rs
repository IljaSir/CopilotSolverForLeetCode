impl Solution {
    pub fn intersect(nums1: Vec<i32>, nums2: Vec<i32>) -> Vec<i32> {
        
        let mut nums1 = nums1;
        let mut nums2 = nums2;
        let mut result = Vec::new();
        nums1.sort();
        nums2.sort();
        let mut i = 0;
        let mut j = 0;
        while i < nums1.len() && j < nums2.len() {
            if nums1[i] == nums2[j] {
                result.push(nums1[i]);
                i += 1;
                j += 1;
            } else if nums1[i] < nums2[j] {
                i += 1;
            } else {
                j += 1;
            }
        }
        result
    }
}