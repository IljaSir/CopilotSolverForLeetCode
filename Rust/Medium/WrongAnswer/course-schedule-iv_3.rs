impl Solution {
    pub fn check_if_prerequisite(num_courses: i32, prerequisites: Vec<Vec<i32>>, queries: Vec<Vec<i32>>) -> Vec<bool> {
        
        let mut graph = vec![vec![]; num_courses as usize];
        for p in prerequisites {
            graph[p[0] as usize].push(p[1] as usize);
        }
        let mut dp = vec![vec![false; num_courses as usize]; num_courses as usize];
        for i in 0..num_courses {
            let mut visited = vec![false; num_courses as usize];
            Self::dfs(i as usize, &graph, &mut visited, &mut dp);
        }
        let mut ans = vec![];
        for q in queries {
            ans.push(dp[q[0] as usize][q[1] as usize]);
        }
        ans
    }
    fn dfs(i: usize, graph: &Vec<Vec<usize>>, visited: &mut Vec<bool>, dp: &mut Vec<Vec<bool>>) {
        if visited[i] {
            return;
        }
        visited[i] = true;
        for &j in graph[i].iter() {
            dp[i][j] = true;
            Self::dfs(j, graph, visited, dp);
        }
    }
}