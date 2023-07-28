impl Solution {
    pub fn minimize_set(divisor1: i32, divisor2: i32, unique_cnt1: i32, unique_cnt2: i32) -> i32 {
        
        let (mut lo, mut hi) = (1, unique_cnt1 + unique_cnt2);
        while lo < hi {
            let mid = (lo + hi) / 2;
            if mid - mid / divisor1 - mid / divisor2 + mid / (divisor1 * divisor2) >= unique_cnt1.min(unique_cnt2) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        lo
    }
}