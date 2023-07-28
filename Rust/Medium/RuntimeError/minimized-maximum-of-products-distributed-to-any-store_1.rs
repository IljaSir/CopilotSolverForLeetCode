impl Solution {
    pub fn minimized_maximum(n: i32, quantities: Vec<i32>) -> i32 {
        
        let n = n as i64;
        let mut lo = 0;
        let mut hi = *quantities.iter().max().unwrap() as i64;
        while lo < hi {
            let mid = (lo + hi) / 2;
            let mut sum = 0;
            for &q in quantities.iter() {
                sum += (q as i64 + mid - 1) / mid;
            }
            if sum <= n {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        lo as i32
    }
}