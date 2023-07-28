impl Solution {
    pub fn maximum_score(a: i32, b: i32, c: i32) -> i32 {
        
        let mut a = a;
        let mut b = b;
        let mut c = c;
        let mut r = 0;
        while a + b + c > 2 {
            let m = std::cmp::max(a, std::cmp::max(b, c));
            if m == a {
                a -= 1;
                b -= 1;
            } else if m == b {
                a -= 1;
                c -= 1;
            } else {
                b -= 1;
                c -= 1;
            }
            r += 1;
        }
        r
    }
}