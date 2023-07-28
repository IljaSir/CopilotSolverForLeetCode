impl Solution {
    pub fn num_points(darts: Vec<Vec<i32>>, r: i32) -> i32 {
        
        let r = r as f64;
        let n = darts.len();
        let mut res = 1;
        for i in 0..n {
            for j in 0..n {
                let a = darts[i].clone();
                let b = darts[j].clone();
                if (a[0] - b[0]).pow(2) + (a[1] - b[1]).pow(2) > 4 * r * r {
                    continue;
                }
                let (x1, y1) = (a[0] as f64, a[1] as f64);
                let (x2, y2) = (b[0] as f64, b[1] as f64);
                let (x3, y3) = (darts[(i + 1) % n][0] as f64, darts[(i + 1) % n][1] as f64);
                let (x4, y4) = (darts[(j + 1) % n][0] as f64, darts[(j + 1) % n][1] as f64);
                let (x12, y12) = ((x1 + x2) / 2.0, (y1 + y2) / 2.0);
                let (x34, y34) = ((x3 + x4) / 2.0, (y3 + y4) / 2.0);
                let (dx1, dy1) = (y2 - y1, x1 - x2);
                let (dx2, dy2) = (y4 - y3, x3 - x4);
                let (dx12, dy12) = (y34 - y12, x12 - x34);
                let (dx21, dy21) = (y12 - y34, x34 - x12);
                let (dx, dy) = if dx1 * dx1 + dy1 * dy1 > dx2 * dx2 + dy2 * dy2 {
                    (dx1, dy1)
                } else {
                    (dx2, dy2)
                };
                let (dx, dy) = if dx * dx + dy * dy > dx12 * dx12 + dy12 * dy12 {
    }
}