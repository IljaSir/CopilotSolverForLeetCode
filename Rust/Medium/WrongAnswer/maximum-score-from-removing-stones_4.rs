impl Solution {
    pub fn maximum_score(a: i32, b: i32, c: i32) -> i32 {
        
        let (a, b, c) = (a as usize, b as usize, c as usize);
        let (mut a, mut b, mut c) = (a, b, c);
        if a > b { std::mem::swap(&mut a, &mut b); }
        if b > c { std::mem::swap(&mut b, &mut c); }
        if a > b { std::mem::swap(&mut a, &mut b); }
        let mut res = 0;
        if a == 0 {
            res += b / 2;
            b %= 2;
            res += c / 2;
            c %= 2;
        } else if a + b == c {
            res += a;
        } else if a + b < c {
            res += a;
            res += (b + c - a) / 2;
        } else {
            res += (a + b + c) / 2;
        }
        res as i32
    }
}