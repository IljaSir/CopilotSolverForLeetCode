impl Solution {
    pub fn first_bad_version(&self, n: i32) -> i32 {
		
        let mut l = 1;
        let mut r = n;
        while l < r {
            let mid = l + (r - l) / 2;
            if self.isBadVersion(mid) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        l
    }
}