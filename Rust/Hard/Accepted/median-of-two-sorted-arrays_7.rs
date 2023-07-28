impl Solution {
    pub fn find_median_sorted_arrays(nums1: Vec<i32>, nums2: Vec<i32>) -> f64 {
        
        let (mut i, mut j) = (0, 0);
        let (mut nums1, mut nums2) = (nums1, nums2);
        let mut res = vec![];
        while i < nums1.len() && j < nums2.len() {
            if nums1[i] <= nums2[j] {
                res.push(nums1[i]);
                i += 1;
            } else {
                res.push(nums2[j]);
                j += 1;
            }
        }
        if i < nums1.len() {
            res.extend(&nums1[i..]);
        }
        if j < nums2.len() {
            res.extend(&nums2[j..]);
        }
        let n = res.len();
        if n % 2 == 0 {
            (res[n / 2] + res[n / 2 - 1]) as f64 / 2.0
        } else {
            res[n / 2] as f64
        }
    }
}