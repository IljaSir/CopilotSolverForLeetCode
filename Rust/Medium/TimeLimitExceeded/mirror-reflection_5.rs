impl Solution {
    pub fn mirror_reflection(p: i32, q: i32) -> i32 {
        
        let mut x = 1;
        let mut y = 1;
        let mut res = 0;
        while x * p != y * q {
            x += 1;
            y = (x * q) / p;
            res = (res + 1) % 2;
        }
        res + 2 * (y % 2)
    }
}