impl Solution {
    pub fn find_order(num_courses: i32, prerequisites: Vec<Vec<i32>>) -> Vec<i32> {
        

        let mut graph = vec![vec![]; num_courses as usize];
        let mut indegree = vec![0; num_courses as usize];
        for edge in &prerequisites {
            graph[edge[1] as usize].push(edge[0] as usize);
            indegree[edge[0] as usize] += 1;
        }
        let mut queue = indegree
            .iter()
            .enumerate()
            .filter(|(_, &x)| x == 0)
            .map(|(i, _)| i)
            .collect::<Vec<_>>();
        let mut order = vec![];
        while !queue.is_empty() {
            let node = queue.remove(0);
            order.push(node as i32);
            for &next in &graph[node] {
                indegree[next] -= 1;
                if indegree[next] == 0 {
                    queue.push(next);
                }
            }
        }
        if order.len() == num_courses as usize {
            order
        } else {
            vec![]
        }
    }
}