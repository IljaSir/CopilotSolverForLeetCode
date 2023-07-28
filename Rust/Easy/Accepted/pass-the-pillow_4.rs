impl Solution {
    pub fn pass_the_pillow(n: i32, time: i32) -> i32 {
        
        let mut t = time;
        let mut p = 1;
        let mut d = 1;
        while t > 0 {
            p += d;
            if p == n + 1 {
                p = n - 1;
                d = -1;
            } else if p == 0 {
                p = 2;
                d = 1;
            }
            t -= 1;
        }
        p
    }
}