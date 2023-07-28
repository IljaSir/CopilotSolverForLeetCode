impl Solution {
    pub fn maximal_network_rank(n: i32, roads: Vec<Vec<i32>>) -> i32 {
        
        let mut road = vec![vec![false; n as usize]; n as usize];
        let mut degree = vec![0; n as usize];
        for r in roads {
            let (a, b) = (r[0] as usize, r[1] as usize);
            if !road[a][b] {
                road[a][b] = true;
                road[b][a] = true;
                degree[a] += 1;
                degree[b] += 1;
            }
        }
        let mut max = 0;
        for i in 0..n {
            for j in i+1..n {
                let mut d = degree[i as usize] + degree[j as usize];
                if road[i as usize][j as usize] {
                    d -= 1;
                }
                max = max.max(d);
            }
        }
        max
    }
}