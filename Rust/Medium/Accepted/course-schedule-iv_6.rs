impl Solution {
    pub fn check_if_prerequisite(num_courses: i32, prerequisites: Vec<Vec<i32>>, queries: Vec<Vec<i32>>) -> Vec<bool> {
        
        let mut graph = vec![vec![]; num_courses as usize];
        for edge in prerequisites {
            graph[edge[0] as usize].push(edge[1] as usize);
        }
        let num_courses = num_courses as usize;
        let mut dp = vec![vec![false; num_courses]; num_courses];
        for i in 0..num_courses {
            let mut visited = vec![false; num_courses];
            let mut stack = vec![i];
            while let Some(node) = stack.pop() {
                if !visited[node] {
                    visited[node] = true;
                    for &next in &graph[node] {
                        dp[i][next] = true;
                        stack.push(next);
                    }
                }
            }
        }
        let mut result = Vec::new();
        for query in queries {
            result.push(dp[query[0] as usize][query[1] as usize]);
        }
        result
    }
}