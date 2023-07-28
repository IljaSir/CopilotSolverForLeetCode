impl Solution {
    pub fn min_area_free_rect(points: Vec<Vec<i32>>) -> f64 {
        
        let mut ans = f64::MAX;
        let n = points.len();
        for i in 0..n {
            for j in i+1..n {
                for k in j+1..n {
                    let (x1, y1) = (points[i][0], points[i][1]);
                    let (x2, y2) = (points[j][0], points[j][1]);
                    let (x3, y3) = (points[k][0], points[k][1]);
                    if (x1-x2)*(x1-x3)+(y1-y2)*(y1-y3) == 0 {
                        let area = ((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2)) as f64;
                        if area > 0.0 && area < ans {
                            ans = area;
                        }
                    }
                }
            }
        }
        if ans == f64::MAX {
            return 0.0;
        }
        return ans;
    }
}