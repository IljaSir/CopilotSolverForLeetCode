impl Solution {
    pub fn min_cost_connect_points(points: Vec<Vec<i32>>) -> i32 {
        
        let n = points.len();
        let mut dists = vec![vec![std::i32::MAX; n]; n];
        for i in 0..n {
            for j in i+1..n {
                let d = (points[i][0] - points[j][0]).abs() + (points[i][1] - points[j][1]).abs();
                dists[i][j] = d;
                dists[j][i] = d;
            }
        }
        let mut visited = vec![false; n];
        let mut dist = vec![std::i32::MAX; n];
        let mut res = 0;
        dist[0] = 0;
        for _ in 0..n {
            let mut min_dist = std::i32::MAX;
            let mut min_idx = 0;
            for i in 0..n {
                if !visited[i] && dist[i] < min_dist {
                    min_idx = i;
                    min_dist = dist[i];
                }
            }
            visited[min_idx] = true;
            res += min_dist;
            for i in 0..n {
                if !visited[i] && dists[min_idx][i] < dist[i] {
                    dist[i] = dists[min_idx][i];
                }
            }
        }
        res
    }
}