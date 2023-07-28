impl Solution {
    pub fn find_cheapest_price(n: i32, flights: Vec<Vec<i32>>, src: i32, dst: i32, k: i32) -> i32 {
        
        let mut g = vec![vec![]; n as usize];
        for f in flights {
            g[f[0] as usize].push((f[1], f[2]));
        }
        let mut q = std::collections::BinaryHeap::new();
        q.push((0, src, k + 1));
        let mut visited = std::collections::HashSet::new();
        while let Some((cost, city, remain)) = q.pop() {
            if city == dst {
                return -cost;
            }
            if remain > 0 {
                for (n, c) in &g[city as usize] {
                    if !visited.contains(&(*n, remain - 1)) {
                        visited.insert((*n, remain - 1));
                        q.push((cost - c, *n, remain - 1));
                    }
                }
            }
        }
        -1
    }
}