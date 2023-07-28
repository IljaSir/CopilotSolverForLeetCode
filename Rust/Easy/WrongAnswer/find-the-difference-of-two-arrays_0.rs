impl Solution {
    pub fn find_difference(nums1: Vec<i32>, nums2: Vec<i32>) -> Vec<Vec<i32>> {
        
        let mut nums1: Vec<i32> = nums1;
        let mut nums2: Vec<i32> = nums2;
        nums1.sort();
        nums2.sort();
        let mut i = 0;
        let mut j = 0;
        let mut result: Vec<Vec<i32>> = vec![vec![], vec![]];
        while i < nums1.len() && j < nums2.len() {
            if nums1[i] == nums2[j] {
                i += 1;
                j += 1;
            } else if nums1[i] > nums2[j] {
                result[1].push(nums2[j]);
                j += 1;
            } else {
                result[0].push(nums1[i]);
                i += 1;
            }
        }
        if i < nums1.len() {
            result[0].extend_from_slice(&nums1[i..]);
        }
        if j < nums2.len() {
            result[1].extend_from_slice(&nums2[j..]);
        }
        result
    }
}