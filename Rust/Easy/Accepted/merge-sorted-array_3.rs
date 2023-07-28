impl Solution {
    pub fn merge(nums1: &mut Vec<i32>, m: i32, nums2: &mut Vec<i32>, n: i32) {
        
        let mut i = m - 1;
        let mut j = n - 1;
        let mut k = (m + n - 1) as usize;
        while i >= 0 && j >= 0 {
            if nums1[i as usize] > nums2[j as usize] {
                nums1[k] = nums1[i as usize];
                i -= 1;
            } else {
                nums1[k] = nums2[j as usize];
                j -= 1;
            }
            k -= 1;
        }
        while j >= 0 {
            nums1[k] = nums2[j as usize];
            j -= 1;
            k -= 1;
        }
    }
}