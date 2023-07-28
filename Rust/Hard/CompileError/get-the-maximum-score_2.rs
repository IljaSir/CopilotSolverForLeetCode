impl Solution {
    pub fn max_sum(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
        
        let mut ans = 0;
        let mut i = 0;
        let mut j = 0;
        let mut t1 = 0;
        let mut t2 = 0;
        while i < nums1.len() && j < nums2.len() {
            if nums1[i] < nums2[j] {
                t1 += nums1[i];
                i += 1;
            } else if nums1[i] > nums2[j] {
                t2 += nums2[j];
                j += 1;
            } else {
                ans += nums1[i].max(t1, t2);
                t1 = 0;
                t2 = 0;
                i += 1;
                j += 1;
            }
        }
        while i < nums1.len() {
            t1 += nums1[i];
            i += 1;
        }
        while j < nums2.len() {
            t2 += nums2[j];
            j += 1;
        }
        ans += t1.max(t2);
        ans % 1_000_000_007
    }
}