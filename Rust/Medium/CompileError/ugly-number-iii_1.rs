impl Solution {
    pub fn nth_ugly_number(n: i32, a: i32, b: i32, c: i32) -> i32 {
        
        let (a, b, c) = (a as i64, b as i64, c as i64);
        let (mut l, mut r) = (1, 2 * 10i64.pow(9));
        while l < r {
            let m = l + (r - l) / 2;
            let count = m / a + m / b + m / c - m / (a.lcm(&b)) - m / (a.lcm(&c)) - m / (b.lcm(&c)) + m / (a.lcm(&b.lcm(&c)));
            if count < n as i64 {
                l = m + 1;
            } else {
                r = m;
            }
        }
        l as i32
    }
}