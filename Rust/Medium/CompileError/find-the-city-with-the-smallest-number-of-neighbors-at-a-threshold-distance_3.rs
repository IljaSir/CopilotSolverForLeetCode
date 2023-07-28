impl Solution {
    pub fn find_the_city(n: i32, edges: Vec<Vec<i32>>, distance_threshold: i32) -> i32 {
        
        let n = n as usize;
        let mut g = vec![vec![std::i32::MAX; n]; n];
        for edge in edges {
            let (u, v, w) = (edge[0] as usize, edge[1] as usize, edge[2] as usize);
            g[u][v] = w;
            g[v][u] = w;
        }
        for i in 0..n {
            g[i][i] = 0;
        }
        for k in 0..n {
            for i in 0..n {
                for j in 0..n {
                    g[i][j] = g[i][j].min(g[i][k] + g[k][j]);
                }
            }
        }
        let mut ans = 0;
        let mut min = n;
        for i in 0..n {
            let mut cnt = 0;
            for j in 0..n {
                if g[i][j] <= distance_threshold {
                    cnt += 1;
                }
            }
            if cnt <= min {
                ans = i;
                min = cnt;
            }
        }
        ans as i32
    }
}