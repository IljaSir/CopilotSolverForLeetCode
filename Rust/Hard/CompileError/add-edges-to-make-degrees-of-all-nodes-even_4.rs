impl Solution {
    pub fn is_possible(n: i32, edges: Vec<Vec<i32>>) -> bool {
        
        let mut degree = vec![0; n as usize];
        let mut g = vec![vec![]; n as usize];
        for e in edges {
            g[e[0] as usize - 1].push(e[1] as usize - 1);
            g[e[1] as usize - 1].push(e[0] as usize - 1);
            degree[e[0] as usize - 1] += 1;
            degree[e[1] as usize - 1] += 1;
        }
        let mut odd = 0;
        for i in 0..n as usize {
            if degree[i] % 2 == 1 {
                odd += 1;
            }
        }
        if odd > 2 {
            return false;
        }
        let mut visited = vec![false; n as usize];
        let mut count = 0;
        for i in 0..n as usize {
            if !visited[i] {
                count += 1;
                Self::dfs(i, &mut visited, &g);
            }
        }
        if count == 1 {
            return true;
        }
        if odd == 0 {
            return true;
        }
        if odd == 2 {
            return false;
        }
        false
    }
    fn dfs(i: usize, visited: &mut Vec<bool>, g: &Vec<Vec<usize>>) {
        visited[i] = true;
        for j in &g[i] {
            if !visited[*j] {
                Self::dfs(*j, visited, g);
            }
        }