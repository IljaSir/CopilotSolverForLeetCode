impl Solution {
    pub fn pass_the_pillow(n: i32, time: i32) -> i32 {
        
        let mut time = time;
        let mut direction = 1;
        let mut position = 1;
        while time > 0 {
            time -= 1;
            position += direction;
            if position == n+1 {
                direction = -1;
                position = n-1;
            } else if position == 0 {
                direction = 1;
                position = 2;
            }
        }
        position
    }
}