impl Solution {
    pub fn nth_ugly_number(n: i32, a: i32, b: i32, c: i32) -> i32 {
        
        let mut left = 0;
        let mut right = 2 * 10i64.pow(9);
        let ab = a.lcm(&b);
        let ac = a.lcm(&c);
        let bc = b.lcm(&c);
        let abc = a.lcm(&bc);
        while left < right {
            let mid = (left + right) / 2;
            let count = mid / a + mid / b + mid / c - mid / ab - mid / ac - mid / bc + mid / abc;
            if count < n as i64 {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        right as i32
    }
}