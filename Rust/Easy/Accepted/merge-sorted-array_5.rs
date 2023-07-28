impl Solution {
    pub fn merge(nums1: &mut Vec<i32>, m: i32, nums2: &mut Vec<i32>, n: i32) {
        
        let mut i = (m - 1) as usize;
        let mut j = (n - 1) as usize;
        let mut k = (m + n - 1) as usize;
        while i != usize::MAX && j != usize::MAX {
            if nums1[i] > nums2[j] {
                nums1[k] = nums1[i];
                i -= 1;
            } else {
                nums1[k] = nums2[j];
                j -= 1;
            }
            k -= 1;
        }
        while j != usize::MAX {
            nums1[k] = nums2[j];
            j -= 1;
            k -= 1;
        }
    }
}