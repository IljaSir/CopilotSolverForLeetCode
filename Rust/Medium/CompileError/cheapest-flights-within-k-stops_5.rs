impl Solution {
    pub fn find_cheapest_price(n: i32, flights: Vec<Vec<i32>>, src: i32, dst: i32, k: i32) -> i32 {
        
        let n = n as usize;
        let mut graph = vec![vec![]; n];
        for flight in flights {
            let from = flight[0] as usize;
            let to = flight[1] as usize;
            let cost = flight[2];
            graph[from].push((to, cost));
        }
        let mut cost = vec![i32::max_value(); n];
        cost[src as usize] = 0;
        let mut queue = std::collections::VecDeque::new();
        queue.push_back((src, 0));
        while let Some((city, stop)) = queue.pop_front() {
            if stop > k + 1 {
                continue;
            }
            for (to, price) in &graph[city as usize] {
                let new_cost = cost[city as usize] + price;
                if new_cost < cost[*to] {
                    cost[*to] = new_cost;
                    queue.push_back((*to, stop + 1));
                }
            }
        }
        if cost[dst as usize] == i32::max_value() {
            -1
        } else {
            cost[dst as usize]
        }
    }
}