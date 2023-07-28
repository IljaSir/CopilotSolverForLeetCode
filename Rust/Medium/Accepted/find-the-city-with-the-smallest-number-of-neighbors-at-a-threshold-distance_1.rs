impl Solution {
    pub fn find_the_city(n: i32, edges: Vec<Vec<i32>>, distance_threshold: i32) -> i32 {
        
        let n = n as usize;
        let mut dist = vec![vec![i32::max_value(); n]; n];
        for i in 0..n {
            dist[i][i] = 0;
        }
        for e in edges {
            let u = e[0] as usize;
            let v = e[1] as usize;
            let w = e[2];
            dist[u][v] = w;
            dist[v][u] = w;
        }
        for k in 0..n {
            for i in 0..n {
                for j in 0..n {
                    if dist[i][k] != i32::max_value() && dist[k][j] != i32::max_value() {
                        if dist[i][k] + dist[k][j] < dist[i][j] {
                            dist[i][j] = dist[i][k] + dist[k][j];
                        }
                    }
                }
            }
        }
        let mut ans = 0;
        let mut min = n;
        for i in 0..n {
            let mut cnt = 0;
            for j in 0..n {
                if dist[i][j] <= distance_threshold {
                    cnt += 1;
                }
            }
            if cnt <= min {
                min = cnt;
                ans = i;
            }
        }
        ans as i32
    }
}