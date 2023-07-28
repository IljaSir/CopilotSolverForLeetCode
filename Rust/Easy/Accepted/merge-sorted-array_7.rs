impl Solution {
    pub fn merge(nums1: &mut Vec<i32>, m: i32, nums2: &mut Vec<i32>, n: i32) {
        
        let mut m = m;
        let mut n = n;
        let mut p = m + n - 1;
        while m > 0 && n > 0 {
            if nums1[(m - 1) as usize] < nums2[(n - 1) as usize] {
                nums1[p as usize] = nums2[(n - 1) as usize];
                n -= 1;
            } else {
                nums1[p as usize] = nums1[(m - 1) as usize];
                m -= 1;
            }
            p -= 1;
        }
        while n > 0 {
            nums1[p as usize] = nums2[(n - 1) as usize];
            n -= 1;
            p -= 1;
        }
    }
}