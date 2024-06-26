impl Solution {
    pub fn max_points(points: Vec<Vec<i32>>) -> i32 {
        
        let n = points.len();
        if n < 3 {
            return n as i32;
        }
        let mut ans = 2;
        for i in 0..n {
            let mut map = std::collections::HashMap::new();
            let mut same = 0;
            for j in (i + 1)..n {
                let (x1, y1) = (points[i][0], points[i][1]);
                let (x2, y2) = (points[j][0], points[j][1]);
                if x1 == x2 && y1 == y2 {
                    same += 1;
                    continue;
                }
                let (mut a, mut b) = (y2 - y1, x2 - x1);
                let g = gcd(a, b);
                a /= g;
                b /= g;
                *map.entry((a, b)).or_insert(0) += 1;
            }
            ans = ans.max(map.values().max().cloned().unwrap_or(0) + same + 1);
        }
        ans
    }
    fn gcd(a: i32, b: i32) -> i32 {
        if b == 0 {
            return a;
        }
        Self::gcd(b, a % b)
    }
}