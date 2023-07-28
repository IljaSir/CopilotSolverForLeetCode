impl Solution {
    pub fn preimage_size_fzf(k: i32) -> i32 {
        
        let k = k as i64;
        let mut l = 0;
        let mut r = 5 * (k + 1) as i64;
        while l < r {
            let mid = l + (r - l) / 2;
            let count = Self::trailing_zeroes(mid);
            if count == k {
                return 5;
            } else if count < k {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        0
    }
    
    fn trailing_zeroes(n: i64) -> i64 {
        let mut n = n;
        let mut count = 0;
        while n > 0 {
            n /= 5;
            count += n;
        }
        count
    }
}