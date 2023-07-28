impl Solution {
    pub fn preimage_size_fzf(k: i32) -> i32 {
        
        let k = k as u64;
        let mut l = 0;
        let mut r = 5 * k;
        while l < r {
            let m = l + (r - l) / 2;
            let t = Self::trailing_zeros(m);
            if t > k {
                r = m;
            } else if t < k {
                l = m + 1;
            } else {
                return 5;
            }
        }
        0
    }
    fn trailing_zeros(n: u64) -> u64 {
        let mut n = n;
        let mut res = 0;
        while n > 0 {
            n /= 5;
            res += n;
        }
        res
    }
}