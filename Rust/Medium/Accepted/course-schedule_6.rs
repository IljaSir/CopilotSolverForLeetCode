impl Solution {
    pub fn can_finish(num_courses: i32, prerequisites: Vec<Vec<i32>>) -> bool {
        

        let mut graph: Vec<Vec<i32>> = vec![vec![]; num_courses as usize];
        let mut visited: Vec<i32> = vec![0; num_courses as usize];
        for pre in prerequisites {
            graph[pre[1] as usize].push(pre[0]);
        }
        for i in 0..num_courses {
            if !Self::dfs(i as usize, &mut visited, &graph) {
                return false;
            }
        }
        true
    }
    fn dfs(node: usize, visited: &mut Vec<i32>, graph: &Vec<Vec<i32>>) -> bool {
        if visited[node] == -1 {
            return false;
        }
        if visited[node] == 1 {
            return true;
        }
        visited[node] = -1;
        for &v in graph[node].iter() {
            if !Self::dfs(v as usize, visited, graph) {
                return false;
            }
        }
        visited[node] = 1;
        true
    }
}