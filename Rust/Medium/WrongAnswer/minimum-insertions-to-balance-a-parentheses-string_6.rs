impl Solution {
    pub fn min_insertions(s: String) -> i32 {
        
        let mut a = 0;
        let mut b = 0;
        let mut r = 0;
        for c in s.chars() {
            if c == '(' {
                if b % 2 == 1 {
                    b -= 1;
                    r += 1;
                }
                a += 1;
            } else {
                b += 1;
            }
            if b == 2 {
                a -= 1;
                b = 0;
                r += 1;
            }
        }
        r + a * 2 + b
    }
}