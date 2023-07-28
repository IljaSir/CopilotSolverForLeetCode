impl Solution {
    pub fn can_finish(num_courses: i32, prerequisites: Vec<Vec<i32>>) -> bool {
        

        let mut graph: Vec<Vec<i32>> = vec![vec![]; num_courses as usize];
        for v in prerequisites {
            graph[v[1] as usize].push(v[0]);
        }
        let mut visited = vec![0; num_courses as usize];
        for i in 0..num_courses {
            if !Self::dfs(&graph, i as usize, &mut visited) {
                return false;
            }
        }
        true
    }
    fn dfs(graph: &Vec<Vec<i32>>, i: usize, visited: &mut Vec<i32>) -> bool {
        if visited[i] == 1 { return true; }
        if visited[i] == 2 { return false; }
        visited[i] = 2;
        for &j in &graph[i] {
            if !Self::dfs(graph, j as usize, visited) {
                return false;
            }
        }
        visited[i] = 1;
        true
    }
}