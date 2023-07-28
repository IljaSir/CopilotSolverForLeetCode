impl Solution {
    pub fn find_order(num_courses: i32, prerequisites: Vec<Vec<i32>>) -> Vec<i32> {
        

        let mut graph = vec![vec![]; num_courses as usize];
        let mut indegree = vec![0; num_courses as usize];
        for edge in prerequisites {
            graph[edge[1] as usize].push(edge[0]);
            indegree[edge[0] as usize] += 1;
        }
        let mut queue: Vec<i32> = (0..num_courses).filter(|i| indegree[*i as usize] == 0).collect();
        let mut order: Vec<i32> = Vec::new();
        while let Some(node) = queue.pop() {
            order.push(node);
            for &child in &graph[node as usize] {
                indegree[child as usize] -= 1;
                if indegree[child as usize] == 0 {
                    queue.push(child);
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