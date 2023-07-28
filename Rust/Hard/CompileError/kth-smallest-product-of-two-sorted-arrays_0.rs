impl Solution {
    pub fn kth_smallest_product(nums1: Vec<i32>, nums2: Vec<i32>, k: i64) -> i64 {
        
        let (n, m) = (nums1.len(), nums2.len());
        let (mut l, mut r) = (nums1[0] * nums2[0], nums1[n - 1] * nums2[m - 1]);
        while l < r {
            let mid = l + (r - l) / 2;
            let mut c = 0;
            for i in 0..n {
                let mut j = m;
                while j > 0 && nums1[i] * nums2[j - 1] > mid {
                    j -= 1;
                }
                c += j as i64;
            }
            if c < k {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        l
    }
}