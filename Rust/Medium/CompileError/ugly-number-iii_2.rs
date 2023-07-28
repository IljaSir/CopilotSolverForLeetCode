impl Solution {
    pub fn nth_ugly_number(n: i32, a: i32, b: i32, c: i32) -> i32 {
        
        let mut lo = 1;
        let mut hi = 2 * 1e9 as i64;
        let a = a as i64;
        let b = b as i64;
        let c = c as i64;
        let ab = a * b / gcd(a, b);
        let bc = b * c / gcd(b, c);
        let ac = a * c / gcd(a, c);
        let abc = ab * c / gcd(ab, c);
        while lo < hi {
            let mid = lo + (hi - lo) / 2;
            let cnt = mid / a + mid / b + mid / c - mid / ab - mid / bc - mid / ac + mid / abc;
            if cnt >= n as i64 {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        lo as i32
    }
}