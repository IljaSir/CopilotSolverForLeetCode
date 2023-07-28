impl Solution {
    pub fn can_finish(num_courses: i32, prerequisites: Vec<Vec<i32>>) -> bool {
        

        let num_courses = num_courses as usize;
        let mut adj = vec![vec![]; num_courses];
        for p in &prerequisites {
            adj[p[0] as usize].push(p[1] as usize);
        }
        let mut visited = vec![0; num_courses];
        for i in 0..num_courses {
            if visited[i] == 0 && Self::dfs(i, &mut visited, &adj) {
                return false;
            }
        }
        true
    }

    fn dfs(
        i: usize,
        visited: &mut Vec<i32>,
        adj: &Vec<Vec<usize>>,
    ) -> bool {
        visited[i] = 1;
        for &j in &adj[i] {
            if visited[j] == 1 || (visited[j] == 0 && Self::dfs(j, visited, adj)) {
                return true;
            }
        }
        visited[i] = 2;
        false
    }
}