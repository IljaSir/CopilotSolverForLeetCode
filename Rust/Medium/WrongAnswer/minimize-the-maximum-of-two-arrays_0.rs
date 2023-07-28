impl Solution {
    pub fn minimize_set(divisor1: i32, divisor2: i32, unique_cnt1: i32, unique_cnt2: i32) -> i32 {
        
        let (d1, d2) = (divisor1 as i64, divisor2 as i64);
        let (u1, u2) = (unique_cnt1 as i64, unique_cnt2 as i64);
        let (mut l, mut r) = (1, u1 + u2);
        while l < r {
            let m = (l + r) >> 1;
            if m - m / d1 - m / d2 + m / (d1 * d2) < u1 + u2 {
                l = m + 1;
            } else {
                r = m;
            }
        }
        l as i32
    }
}