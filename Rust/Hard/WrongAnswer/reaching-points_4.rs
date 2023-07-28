impl Solution {
    pub fn reaching_points(sx: i32, sy: i32, tx: i32, ty: i32) -> bool {
        
        let mut x = tx;
        let mut y = ty;
        while x > sx && y > sy {
            if x > y {
                x %= y;
            } else {
                y %= x;
            }
        }
        if sx == x {
            (ty - sy) % x == 0
        } else if sy == y {
            (tx - sx) % y == 0
        } else {
            false
        }
    }
}