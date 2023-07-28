impl Solution {
    pub fn find_kth_number(m: i32, n: i32, k: i32) -> i32 {
        
        let mut lo = 1;
        let mut hi = m * n;
        while lo < hi {
            let mi = lo + (hi - lo) / 2;
            let count = (1..=m).map(|i| (mi / i).min(n)).sum::<i32>();
            if count < k {
                lo = mi + 1;
            } else {
                hi = mi;
            }
        }
        lo
    }
}