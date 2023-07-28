impl Solution {
    pub fn find_the_city(n: i32, edges: Vec<Vec<i32>>, distance_threshold: i32) -> i32 {
        
        let mut graph = vec![vec![std::i32::MAX; n as usize]; n as usize];
        for i in 0..n {
            graph[i as usize][i as usize] = 0;
        }
        for edge in edges {
            graph[edge[0] as usize][edge[1] as usize] = edge[2];
            graph[edge[1] as usize][edge[0] as usize] = edge[2];
        }
        for k in 0..n {
            for i in 0..n {
                for j in 0..n {
                    if graph[i as usize][k as usize] != std::i32::MAX && graph[k as usize][j as usize] != std::i32::MAX {
                        graph[i as usize][j as usize] = graph[i as usize][j as usize].min(graph[i as usize][k as usize] + graph[k as usize][j as usize]);
                    }
                }
            }
        }
        let mut res = (0, n);
        for i in 0..n {
            let mut cnt = 0;
            for j in 0..n {
                if graph[i as usize][j as usize] <= distance_threshold {
                    cnt += 1;
                }
            }
            if res.1 >= cnt {
                res = (i, cnt);
            }
        }
        res.0
    }
}