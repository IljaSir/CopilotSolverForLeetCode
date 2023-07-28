impl Solution {
    pub fn longest_cycle(edges: Vec<i32>) -> i32 {
        
        let mut visited = vec![false; edges.len()];
        let mut max_cycle = 0;
        for i in 0..edges.len() {
            if visited[i] {
                continue;
            }
            let mut cycle = 0;
            let mut j = i;
            while !visited[j] {
                visited[j] = true;
                j = edges[j] as usize;
                cycle += 1;
            }
            if j != i {
                cycle = 0;
            }
            max_cycle = max_cycle.max(cycle);
        }
        if max_cycle == 0 {
            return -1;
        }
        max_cycle
    }
}