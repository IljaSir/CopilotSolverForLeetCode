impl Solution {
    pub fn mirror_reflection(p: i32, q: i32) -> i32 {
        
        let (mut x, mut y) = (0, 0);
        let (mut dx, mut dy) = (1, 1);
        while !(x == p && y == 0) {
            x += dx;
            y += dy;
            if x == p || x == 0 {
                dx = -dx;
            }
            if y == p || y == 0 {
                dy = -dy;
            }
        }
        if x == 0 && y == p {
            0
        } else if x == p && y == p {
            1
        } else {
            2
        }
    }
}