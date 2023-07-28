impl Solution {
    pub fn network_delay_time(times: Vec<Vec<i32>>, n: i32, k: i32) -> i32 {
        
        let mut adj_list = vec![vec![]; n as usize];
        for time in times {
            adj_list[time[0] as usize - 1].push((time[1] as usize - 1, time[2]));
        }
        let mut distance = vec![std::i32::MAX; n as usize];
        distance[k as usize - 1] = 0;
        let mut queue = std::collections::BinaryHeap::new();
        queue.push(std::cmp::Reverse((0, k as usize - 1)));
        while let Some(std::cmp::Reverse((dist, node))) = queue.pop() {
            if distance[node] < dist {
                continue;
            }
            for &(next, cost) in adj_list[node].iter() {
                if distance[next] > dist + cost {
                    distance[next] = dist + cost;
                    queue.push(std::cmp::Reverse((dist + cost, next)));
                }
            }
        }
        let max = *distance.iter().max().unwrap();
        if max == std::i32::MAX {
            -1
        } else {
            max
        }
    }
}