impl Solution {
    pub fn reaching_points(sx: i32, sy: i32, tx: i32, ty: i32) -> bool {
        
        let (mut sx, mut sy, mut tx, mut ty) = (sx, sy, tx, ty);
        while tx >= sx && ty >= sy {
            if tx == ty {
                break;
            }
            if tx > ty {
                if ty > sy {
                    tx %= ty;
                } else {
                    return (tx - sx) % ty == 0;
                }
            } else {
                if tx > sx {
                    ty %= tx;
                } else {
                    return (ty - sy) % tx == 0;
                }
            }
        }
        tx == sx && ty == sy
    }
}