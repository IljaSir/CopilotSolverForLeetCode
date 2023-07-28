impl Solution {
    pub fn preimage_size_fzf(k: i32) -> i32 {
        
        let mut l = 0;
        let mut r = 5 * (k as i64) + 1;
        while l < r {
            let mid = l + (r - l) / 2;
            if Solution::fzf(mid) < k {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        if Solution::fzf(l) == k {
            5
        } else {
            0
        }
    }
    pub fn fzf(n: i64) -> i32 {
        let mut n = n;
        let mut res = 0;
        while n > 0 {
            res += (n / 5) as i32;
            n /= 5;
        }
        res
    }
}