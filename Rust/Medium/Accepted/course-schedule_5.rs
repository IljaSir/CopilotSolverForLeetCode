impl Solution {
    pub fn can_finish(num_courses: i32, prerequisites: Vec<Vec<i32>>) -> bool {
        

        let n = num_courses as usize;
        let mut graph = vec![vec![]; n];
        let mut indegree = vec![0; n];
        for edge in prerequisites {
            graph[edge[1] as usize].push(edge[0] as usize);
            indegree[edge[0] as usize] += 1;
        }
        let mut queue = vec![];
        for i in 0..n {
            if indegree[i] == 0 {
                queue.push(i);
            }
        }
        let mut count = 0;
        while let Some(node) = queue.pop() {
            count += 1;
            for &next in &graph[node] {
                indegree[next] -= 1;
                if indegree[next] == 0 {
                    queue.push(next);
                }
            }
        }
        count == n
    }
}