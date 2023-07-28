impl Solution {
    pub fn min_flips(a: i32, b: i32, c: i32) -> i32 {
        
        let mut a = a;
        let mut b = b;
        let mut c = c;
        let mut ans = 0;
        while a > 0 || b > 0 || c > 0 {
            let a0 = a % 2;
            let b0 = b % 2;
            let c0 = c % 2;
            if c0 == 0 {
                ans += a0 + b0;
            } else {
                if a0 == 0 && b0 == 0 {
                    ans += 1;
                }
            }
            a /= 2;
            b /= 2;
            c /= 2;
        }
        ans
    }
}