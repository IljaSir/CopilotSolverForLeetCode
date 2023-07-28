impl Solution {
    pub fn first_bad_version(&self, n: i32) -> i32 {
		
        let mut left = 0;
        let mut right = n;
        while left < right {
            let mid = left + (right - left) / 2;
            if self.isBadVersion(mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        left
    }
}