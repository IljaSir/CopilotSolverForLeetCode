impl Solution {
    pub fn kth_smallest_product(nums1: Vec<i32>, nums2: Vec<i32>, k: i64) -> i64 {
        
        let mut a = nums1;
        let mut b = nums2;
        let mut n = a.len();
        let mut m = b.len();
        if n > m {
            std::mem::swap(&mut a, &mut b);
            std::mem::swap(&mut n, &mut m);
        }
        let mut lo = std::i64::MIN;
        let mut hi = std::i64::MAX;
        while lo < hi {
            let mid = lo + (hi - lo) / 2;
            let mut count = 0;
            for i in 0..n {
                count += b.binary_search(&(mid / a[i] as i64)).unwrap_or_else(|x| x) as i64;
            }
            if count < k {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        lo as i64
    }
}