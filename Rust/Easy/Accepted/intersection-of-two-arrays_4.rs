impl Solution {
    pub fn intersection(nums1: Vec<i32>, nums2: Vec<i32>) -> Vec<i32> {
        
        let mut nums1 = nums1;
        let mut nums2 = nums2;
        nums1.sort();
        nums2.sort();
        let mut idx1 = 0;
        let mut idx2 = 0;
        let mut result = Vec::new();
        while idx1 < nums1.len() && idx2 < nums2.len() {
            if nums1[idx1] < nums2[idx2] {
                idx1 += 1;
            } else if nums1[idx1] > nums2[idx2] {
                idx2 += 1;
            } else {
                if result.is_empty() || nums1[idx1] != result[result.len() - 1] {
                    result.push(nums1[idx1]);
                }
                idx1 += 1;
                idx2 += 1;
            }
        }
        result
    }
}