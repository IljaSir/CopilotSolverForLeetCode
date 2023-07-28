impl Solution {
    pub fn find_order(num_courses: i32, prerequisites: Vec<Vec<i32>>) -> Vec<i32> {
        

        let mut graph = vec![vec![]; num_courses as usize];
        let mut indegree = vec![0; num_courses as usize];
        for edge in prerequisites {
            graph[edge[1] as usize].push(edge[0]);
            indegree[edge[0] as usize] += 1;
        }
        let mut queue = vec![];
        for i in 0..num_courses {
            if indegree[i as usize] == 0 {
                queue.push(i);
            }
        }
        let mut order = vec![];
        while !queue.is_empty() {
            let node = queue.remove(0);
            order.push(node);
            for next in &graph[node as usize] {
                indegree[*next as usize] -= 1;
                if indegree[*next as usize] == 0 {
                    queue.push(*next);
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