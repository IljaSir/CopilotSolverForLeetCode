impl Solution {
    pub fn first_bad_version(&self, n: i32) -> i32 {
		
        let mut lo = 1;
        let mut hi = n;
        while lo < hi {
            let mid = lo + (hi - lo) / 2;
            if self.isBadVersion(mid) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        lo
    }
}