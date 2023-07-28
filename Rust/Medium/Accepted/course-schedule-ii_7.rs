impl Solution {
    pub fn find_order(num_courses: i32, prerequisites: Vec<Vec<i32>>) -> Vec<i32> {
        

        let mut graph = vec![vec![]; num_courses as usize];
        let mut indegree = vec![0; num_courses as usize];
        for pre in prerequisites {
            let (a, b) = (pre[0] as usize, pre[1] as usize);
            graph[b].push(a);
            indegree[a] += 1;
        }
        let mut q = std::collections::VecDeque::new();
        for i in 0..num_courses {
            if indegree[i as usize] == 0 {
                q.push_back(i);
            }
        }
        let mut order = Vec::new();
        while let Some(node) = q.pop_front() {
            order.push(node);
            for &n in &graph[node as usize] {
                indegree[n] -= 1;
                if indegree[n] == 0 {
                    q.push_back(n as i32);
                }
            }
        }
        if order.len() == num_courses as usize {
            order
        } else {
            Vec::new()
        }
    }
}