impl Solution {
    pub fn merge(nums1: &mut Vec<i32>, m: i32, nums2: &mut Vec<i32>, n: i32) {
        
        let (mut m, mut n) = (m as usize, n as usize);
        let mut i = m + n - 1;
        while m > 0 && n > 0 {
            if nums1[m - 1] >= nums2[n - 1] {
                nums1[i] = nums1[m - 1];
                m -= 1;
            } else {
                nums1[i] = nums2[n - 1];
                n -= 1;
            }
            i -= 1;
        }
        if n > 0 {
            nums1[..n].copy_from_slice(&nums2[..n]);
        }
    }
}