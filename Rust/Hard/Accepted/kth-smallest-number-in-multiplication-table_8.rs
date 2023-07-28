impl Solution {
    pub fn find_kth_number(m: i32, n: i32, k: i32) -> i32 {
        
        let mut lo = 1;
        let mut hi = m*n;
        while lo < hi {
            let mid = lo + (hi-lo)/2;
            if Solution::count(m, n, mid) < k {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        lo
    }
    fn count(m: i32, n: i32, mid: i32) -> i32 {
        let mut sum = 0;
        for i in 1..=m {
            sum += std::cmp::min(mid/i, n);
        }
        sum
    }
}