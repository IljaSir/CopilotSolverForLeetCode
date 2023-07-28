impl Solution {
    pub fn min_cost_connect_points(points: Vec<Vec<i32>>) -> i32 {
        
        let n = points.len();
        let mut uf = UnionFind::new(n);
        let mut edges = Vec::new();
        for i in 0..n {
            for j in i + 1..n {
                let cost = (points[i][0] - points[j][0]).abs() + (points[i][1] - points[j][1]).abs();
                edges.push((cost, i, j));
            }
        }
        edges.sort();
        let mut ret = 0;
        let mut num = 1;
        for (cost, x, y) in edges {
            if uf.union(x, y) {
                ret += cost;
                num += 1;
                if num == n {
                    break;
                }
            }
        }
        ret
    }
}