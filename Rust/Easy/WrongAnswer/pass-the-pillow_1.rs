impl Solution {
    pub fn pass_the_pillow(n: i32, time: i32) -> i32 {
        
        let mut t = time % (2*n - 2);
        if t == 0 {
            t = 2*n - 2;
        }
        if t <= n {
            t
        } else {
            2*n - t
        }
    }
}