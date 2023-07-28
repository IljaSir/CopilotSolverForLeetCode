impl Solution {
    pub fn min_number(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
        
        let mut nums1 = nums1;
        let mut nums2 = nums2;
        nums1.sort();
        nums2.sort();
        let mut i = 0;
        let mut j = 0;
        let mut res = 0;
        let mut base = 1;
        while i < nums1.len() || j < nums2.len() {
            if i == nums1.len() {
                res += nums2[j] * base;
                j += 1;
            } else if j == nums2.len() {
                res += nums1[i] * base;
                i += 1;
            } else {
                if nums1[i] < nums2[j] {
                    res += nums1[i] * base;
                    i += 1;
                } else {
                    res += nums2[j] * base;
                    j += 1;
                }
            }
            base *= 10;
        }
        res
    }
}