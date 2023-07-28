impl Solution {
    pub fn pass_the_pillow(n: i32, time: i32) -> i32 {
        
        let mut t = time % (2 * n - 2);
        if t > n {
            t = 2 * n - 2 - t;
        }
        t
    }
}