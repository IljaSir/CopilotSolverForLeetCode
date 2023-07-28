impl Solution {
    pub fn pass_the_pillow(n: i32, time: i32) -> i32 {
        
        let time = time % (2 * n - 2);
        let mut time = time as usize;
        let mut direction = true;
        let mut pos = 1;
        while time > 0 {
            if direction {
                pos += 1;
            } else {
                pos -= 1;
            }
            if pos == 1 {
                direction = true;
            } else if pos == n as usize {
                direction = false;
            }
            time -= 1;
        }
        pos as i32
    }
}