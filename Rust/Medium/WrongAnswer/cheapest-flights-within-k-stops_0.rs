impl Solution {
    pub fn find_cheapest_price(n: i32, flights: Vec<Vec<i32>>, src: i32, dst: i32, k: i32) -> i32 {
        
        let mut graph: Vec<Vec<(i32, i32)>> = vec![vec![]; n as usize];
        for flight in flights {
            graph[flight[0] as usize].push((flight[1], flight[2]));
        }
        let mut dp = vec![std::i32::MAX; n as usize];
        let mut q = std::collections::BinaryHeap::new();
        dp[src as usize] = 0;
        q.push((0, src, k + 1));
        while let Some((cost, city, stops)) = q.pop() {
            let cost = -cost;
            if city == dst {
                return cost;
            }
            if stops > 0 {
                for (next, price) in &graph[city as usize] {
                    let next_cost = cost + price;
                    if next_cost < dp[*next as usize] {
                        dp[*next as usize] = next_cost;
                        q.push((-next_cost, *next, stops - 1));
                    }
                }
            }
        }
        -1
    }
}