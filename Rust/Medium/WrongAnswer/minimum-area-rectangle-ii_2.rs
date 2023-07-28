impl Solution {
    pub fn min_area_free_rect(points: Vec<Vec<i32>>) -> f64 {
        
        let mut ans = std::f64::MAX;
        let mut points = points;
        points.sort_unstable();
        let n = points.len();
        for i in 0..n {
            for j in i+1..n {
                for k in j+1..n {
                    let (x1, y1) = (points[i][0], points[i][1]);
                    let (x2, y2) = (points[j][0], points[j][1]);
                    let (x3, y3) = (points[k][0], points[k][1]);
                    let (x4, y4) = (x1 + x3 - x2, y1 + y3 - y2);
                    if let Ok(idx) = points.binary_search(&vec![x4, y4]) {
                        let area = ((x2 - x1).pow(2) + (y2 - y1).pow(2)) as f64 * ((x3 - x1).pow(2) + (y3 - y1).pow(2)) as f64;
                        ans = ans.min(area.sqrt());
                    }
                }
            }
        }
        if ans == std::f64::MAX {
            0.0
        } else {
            ans
        }
    }
}