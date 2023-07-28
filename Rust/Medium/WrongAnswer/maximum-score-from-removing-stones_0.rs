impl Solution {
    pub fn maximum_score(a: i32, b: i32, c: i32) -> i32 {
        
        let mut a = a;
        let mut b = b;
        let mut c = c;
        if a < b {
            std::mem::swap(&mut a, &mut b);
        }
        if a < c {
            std::mem::swap(&mut a, &mut c);
        }
        if b < c {
            std::mem::swap(&mut b, &mut c);
        }
        let mut score = 0;
        while a > 0 && b > 0 {
            a -= 1;
            b -= 1;
            score += 1;
        }
        if a > 0 {
            let s = std::cmp::min(a, c);
            a -= s;
            c -= s;
            score += s;
        }
        score
    }
}