impl Solution {
    pub fn min_cost_connect_points(points: Vec<Vec<i32>>) -> i32 {
        
        let mut edges = Vec::new();
        for i in 0..points.len() {
            for j in i+1..points.len() {
                let x = points[i][0] - points[j][0];
                let y = points[i][1] - points[j][1];
                edges.push((x.abs() + y.abs(), i, j));
            }
        }
        edges.sort();
        let mut uf = UnionFind::new(points.len());
        let mut ans = 0;
        for (w, x, y) in edges {
            if uf.union(x, y) {
                ans += w;
            }
        }
        ans
    }
}