impl Solution {
    pub fn kth_smallest_product(nums1: Vec<i32>, nums2: Vec<i32>, k: i64) -> i64 {
        
        let n1 = nums1.len();
        let n2 = nums2.len();
        let mut l = nums1[0] * nums2[0];
        let mut r = nums1[n1 - 1] * nums2[n2 - 1];
        while l < r {
            let mid = (l + r) / 2;
            let mut cnt = 0;
            for i in 0..n1 {
                let mut l = 0;
                let mut r = n2;
                while l < r {
                    let mid = (l + r) / 2;
                    if nums2[mid] * nums1[i] <= mid as i32 {
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                }
                cnt += l;
            }
            if cnt < k {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        l
    }
}