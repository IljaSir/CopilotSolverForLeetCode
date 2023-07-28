impl Solution {
    pub fn first_bad_version(&self, n: i32) -> i32 {
		
        let mut l = 1;
        let mut r = n;
        while l < r {
            let m = l + (r - l) / 2;
            if self.isBadVersion(m) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        l
    }
}