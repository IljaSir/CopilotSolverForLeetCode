impl Solution {
    pub fn minimized_maximum(n: i32, quantities: Vec<i32>) -> i32 {
        
        let mut lo = 1;
        let mut hi = quantities.iter().sum::<i32>();
        while lo < hi {
            let mid = lo + (hi - lo) / 2;
            if Self::check(n, mid, &quantities) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        lo
    }
    
    fn check(n: i32, x: i32, quantities: &[i32]) -> bool {
        let mut cnt = 0;
        for &q in quantities {
            cnt += (q + x - 1) / x;
        }
        cnt <= n
    }
}