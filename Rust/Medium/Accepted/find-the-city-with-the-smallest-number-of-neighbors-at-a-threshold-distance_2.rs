impl Solution {
    pub fn find_the_city(n: i32, edges: Vec<Vec<i32>>, distance_threshold: i32) -> i32 {
        
        let mut distance = vec![vec![std::i32::MAX; n as usize]; n as usize];
        for i in 0..n as usize {
            distance[i][i] = 0;
        }
        for edge in edges {
            distance[edge[0] as usize][edge[1] as usize] = edge[2];
            distance[edge[1] as usize][edge[0] as usize] = edge[2];
        }
        for k in 0..n as usize {
            for i in 0..n as usize {
                for j in 0..n as usize {
                    if distance[i][k] != std::i32::MAX && distance[k][j] != std::i32::MAX {
                        distance[i][j] = distance[i][j].min(distance[i][k] + distance[k][j]);
                    }
                }
            }
        }
        let mut min = std::i32::MAX;
        let mut ans = 0;
        for i in 0..n as usize {
            let mut count = 0;
            for j in 0..n as usize {
                if distance[i][j] <= distance_threshold {
                    count += 1;
                }
            }
            if count <= min {
                min = count;
                ans = i;
            }
        }
        ans as i32
    }
}