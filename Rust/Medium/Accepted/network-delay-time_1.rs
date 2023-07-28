impl Solution {
    pub fn network_delay_time(times: Vec<Vec<i32>>, n: i32, k: i32) -> i32 {
        
        let mut graph: Vec<Vec<(i32, i32)>> = vec![vec![]; n as usize];
        for time in times {
            graph[time[0] as usize - 1].push((time[1], time[2]));
        }
        let mut dist = vec![i32::MAX; n as usize];
        let mut visited = vec![false; n as usize];
        dist[k as usize - 1] = 0;
        for _ in 0..n {
            let mut min = i32::MAX;
            let mut min_idx = -1;
            for i in 0..n {
                if !visited[i as usize] && dist[i as usize] < min {
                    min = dist[i as usize];
                    min_idx = i;
                }
            }
            if min_idx == -1 {
                break;
            }
            visited[min_idx as usize] = true;
            for edge in &graph[min_idx as usize] {
                dist[edge.0 as usize - 1] = dist[edge.0 as usize - 1].min(min + edge.1);
            }
        }
        let mut ans = 0;
        for i in 0..n {
            if dist[i as usize] == i32::MAX {
                return -1;
            }
            ans = ans.max(dist[i as usize]);
        }
        ans
    }
}