impl Solution {
    pub fn find_cheapest_price(n: i32, flights: Vec<Vec<i32>>, src: i32, dst: i32, k: i32) -> i32 {
        
        let mut graph = vec![vec![]; n as usize];
        for flight in &flights {
            graph[flight[0] as usize].push((flight[1], flight[2]));
        }
        let mut heap = std::collections::BinaryHeap::new();
        heap.push((0, src, k + 1));
        let mut min = std::i32::MAX;
        while let Some((price, city, stops)) = heap.pop() {
            if city == dst {
                min = min.min(price);
            }
            if stops > 0 {
                for (next, cost) in &graph[city as usize] {
                    if price + cost > min {
                        continue;
                    }
                    heap.push((price + cost, *next, stops - 1));
                }
            }
        }
        if min == std::i32::MAX {
            -1
        } else {
            min
        }
    }
}