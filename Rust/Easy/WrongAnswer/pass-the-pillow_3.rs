impl Solution {
    pub fn pass_the_pillow(n: i32, time: i32) -> i32 {
        
        let t = time % (2 * n - 2);
        if t == 0 {
            return n;
        }
        if t <= n {
            return t;
        }
        n - (t - n)
    }
}