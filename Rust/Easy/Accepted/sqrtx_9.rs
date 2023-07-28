impl Solution {
    pub fn my_sqrt(x: i32) -> i32 {
        
        let x = x as i64;
        let mut l = 0;
        let mut r = x;
        while l <= r {
            let m = (l + r) >> 1;
            let m2 = m * m;
            if m2 == x {
                return m as i32;
            }
            if m2 < x {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        r as i32
    }
}