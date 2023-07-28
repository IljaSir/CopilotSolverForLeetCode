impl Solution {
    pub fn can_finish(num_courses: i32, prerequisites: Vec<Vec<i32>>) -> bool {
        

        if num_courses <= 0 || prerequisites.len() == 0 {
            return true;
        }
        let mut graph = vec![vec![]; num_courses as usize];
        for p in prerequisites {
            graph[p[1] as usize].push(p[0]);
        }
        let mut visited = vec![0; num_courses as usize];
        for i in 0..num_courses {
            if Self::dfs(&graph, &mut visited, i as usize) {
                return false;
            }
        }
        true
    }
    fn dfs(graph: &Vec<Vec<i32>>, visited: &mut Vec<i32>, i: usize) -> bool {
        if visited[i] == -1 {
            return false;
        }
        if visited[i] == 1 {
            return true;
        }
        visited[i] = 1;
        for j in &graph[i] {
            if Self::dfs(graph, visited, *j as usize) {
                return true;
            }
        }
        visited[i] = -1;
        false
    }
}