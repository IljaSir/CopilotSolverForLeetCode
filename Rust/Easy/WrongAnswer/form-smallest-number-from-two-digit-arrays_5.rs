impl Solution {
    pub fn min_number(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
        
        let mut nums1 = nums1;
        let mut nums2 = nums2;
        nums1.sort();
        nums2.sort();
        let mut result = 0;
        let mut n1 = 0;
        let mut n2 = 0;
        while n1 < nums1.len() && n2 < nums2.len() {
            if nums1[n1] < nums2[n2] {
                result = result * 10 + nums1[n1];
                n1 += 1;
            } else {
                result = result * 10 + nums2[n2];
                n2 += 1;
            }
        }
        while n1 < nums1.len() {
            result = result * 10 + nums1[n1];
            n1 += 1;
        }
        while n2 < nums2.len() {
            result = result * 10 + nums2[n2];
            n2 += 1;
        }
        result
    }
}