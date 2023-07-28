impl Solution {
    pub fn maximal_network_rank(n: i32, roads: Vec<Vec<i32>>) -> i32 {
        
        let mut graph = vec![vec![0; n as usize]; n as usize];
        let mut degree = vec![0; n as usize];
        for road in roads {
            let u = road[0] as usize;
            let v = road[1] as usize;
            graph[u][v] = 1;
            graph[v][u] = 1;
            degree[u] += 1;
            degree[v] += 1;
        }
        let mut max = 0;
        for i in 0..n {
            for j in i + 1..n {
                let mut rank = degree[i as usize] + degree[j as usize];
                if graph[i as usize][j as usize] == 1 {
                    rank -= 1;
                }
                if rank > max {
                    max = rank;
                }
            }
        }
        max
    }
}