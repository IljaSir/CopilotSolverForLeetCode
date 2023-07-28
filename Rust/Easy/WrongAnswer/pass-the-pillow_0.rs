impl Solution {
    pub fn pass_the_pillow(n: i32, time: i32) -> i32 {
        
        let mut t = time % (n * 2 - 2);
        if t == 0 {
            t = n * 2 - 2;
        }
        if t <= n {
            t
        } else {
            n * 2 - t
        }
    }
}