impl Solution {
    pub fn check_if_prerequisite(num_courses: i32, prerequisites: Vec<Vec<i32>>, queries: Vec<Vec<i32>>) -> Vec<bool> {
        
        let mut graph = vec![vec![]; num_courses as usize];
        for p in prerequisites {
            graph[p[0] as usize].push(p[1] as usize);
        }
        let mut dp = vec![vec![false; num_courses as usize]; num_courses as usize];
        for i in 0..num_courses {
            let mut visited = vec![false; num_courses as usize];
            visited[i as usize] = true;
            Self::dfs(i as usize, &graph, &mut visited, &mut dp);
        }
        queries.iter().map(|q| dp[q[0] as usize][q[1] as usize]).collect()
    }
    fn dfs(i: usize, graph: &Vec<Vec<usize>>, visited: &mut Vec<bool>, dp: &mut Vec<Vec<bool>>) {
        for j in &graph[i] {
            if !visited[*j] {
                visited[*j] = true;
                dp[i][*j] = true;
                Self::dfs(*j, graph, visited, dp);
            }
        }