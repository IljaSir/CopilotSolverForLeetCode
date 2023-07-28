impl Solution {
    pub fn can_finish(num_courses: i32, prerequisites: Vec<Vec<i32>>) -> bool {
        

        let mut graph = vec![vec![]; num_courses as usize];
        for pre in prerequisites {
            graph[pre[0] as usize].push(pre[1]);
        }
        let mut visited = vec![0; num_courses as usize];
        for i in 0..num_courses {
            if !Self::dfs(i as usize, &graph, &mut visited) {
                return false;
            }
        }
        true
    }
    fn dfs(i: usize, graph: &Vec<Vec<i32>>, visited: &mut Vec<i32>) -> bool {
        if visited[i] == 1 {
            return false;
        }
        if visited[i] == 2 {
            return true;
        }
        visited[i] = 1;
        for &j in &graph[i] {
            if !Self::dfs(j as usize, graph, visited) {
                return false;
            }
        }
        visited[i] = 2;
        true
    }
}