impl Solution {
    pub fn is_self_crossing(distance: Vec<i32>) -> bool {
        
        let (mut x, mut y) = (0, 0);
        let (mut dx, mut dy) = (0, 1);
        let (mut minx, mut miny, mut maxx, mut maxy) = (0, 0, 0, 0);
        for i in 0..distance.len() {
            let d = distance[i];
            x += dx * d;
            y += dy * d;
            minx = minx.min(x);
            miny = miny.min(y);
            maxx = maxx.max(x);
            maxy = maxy.max(y);
            if i == 0 {
                dx = 0;
                dy = 1;
            } else if i == 1 {
                dx = -1;
                dy = 0;
            } else if i == 2 {
                dx = 0;
                dy = -1;
            } else if i == 3 {
                dx = 1;
                dy = 0;
            } else {
                let (mut x0, mut y0) = (x, y);
                let (mut dx0, mut dy0) = (dx, dy);
                let mut d0 = d;
                for _ in 0..4 {
                    x0 += dx0 * d0;
                    y0 += dy0 * d0;
                    minx = minx.min(x0);
                    miny = miny.min(y0);
                    maxx = maxx.max(x0);
                    maxy = maxy.max(y0);
                    if x0 == x && y0 == y {
                        return true;
                    }
                    if dx0 == 0 {
                        dx0 = -dy0;
                        dy0 = 0;
                    } else {
                        dy0 = dx0;
                        dx0 = 0;
                    }
                    d0 = distance[i - 4];
                }
            }
        }
        false
    }
}