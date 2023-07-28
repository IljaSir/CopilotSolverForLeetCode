impl Solution {
    pub fn reaching_points(sx: i32, sy: i32, tx: i32, ty: i32) -> bool {
        
        let (mut x, mut y) = (tx, ty);
        while x >= sx && y >= sy {
            if x == sx && y == sy {
                return true;
            }
            if x >= y {
                x -= y;
            } else {
                y -= x;
            }
        }
        false
    }
}