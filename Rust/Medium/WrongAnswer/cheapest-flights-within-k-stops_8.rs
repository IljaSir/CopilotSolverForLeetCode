impl Solution {
    pub fn find_cheapest_price(n: i32, flights: Vec<Vec<i32>>, src: i32, dst: i32, k: i32) -> i32 {
        
        let mut graph = vec![vec![]; n as usize];
        for flight in flights {
            graph[flight[0] as usize].push((flight[1], flight[2]));
        }
        let mut dist = vec![std::i32::MAX; n as usize];
        dist[src as usize] = 0;
        let mut heap = std::collections::BinaryHeap::new();
        heap.push(std::cmp::Reverse((0, src, k + 1)));
        while let Some(std::cmp::Reverse((cost, city, stops))) = heap.pop() {
            if city == dst {
                return cost;
            }
            if stops > 0 {
                for (next, price) in &graph[city as usize] {
                    let new_cost = cost + price;
                    if new_cost < dist[*next as usize] {
                        dist[*next as usize] = new_cost;
                        heap.push(std::cmp::Reverse((new_cost, *next, stops - 1)));
                    }
                }
            }
        }
        -1
    }
}