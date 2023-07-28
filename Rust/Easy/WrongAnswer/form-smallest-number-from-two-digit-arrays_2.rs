impl Solution {
    pub fn min_number(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
        
        let mut nums1 = nums1;
        let mut nums2 = nums2;
        nums1.sort();
        nums2.sort();
        let mut num = 0;
        let mut i = 0;
        let mut j = 0;
        while i < nums1.len() && j < nums2.len() {
            if nums1[i] < nums2[j] {
                num = num * 10 + nums1[i];
                i += 1;
            } else {
                num = num * 10 + nums2[j];
                j += 1;
            }
        }
        while i < nums1.len() {
            num = num * 10 + nums1[i];
            i += 1;
        }
        while j < nums2.len() {
            num = num * 10 + nums2[j];
            j += 1;
        }
        num
    }
}