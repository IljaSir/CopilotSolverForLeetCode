impl Solution {
    pub fn can_finish(num_courses: i32, prerequisites: Vec<Vec<i32>>) -> bool {
        

        let mut graph = vec![vec![]; num_courses as usize];
        let mut indegrees = vec![0; num_courses as usize];
        for edge in prerequisites {
            graph[edge[1] as usize].push(edge[0] as usize);
            indegrees[edge[0] as usize] += 1;
        }
        let mut queue = Vec::new();
        for i in 0..num_courses as usize {
            if indegrees[i] == 0 {
                queue.push(i);
            }
        }
        let mut ans = 0;
        while let Some(u) = queue.pop() {
            ans += 1;
            for &v in &graph[u] {
                indegrees[v] -= 1;
                if indegrees[v] == 0 {
                    queue.push(v);
                }
            }
        }
        ans == num_courses as usize
    }
}