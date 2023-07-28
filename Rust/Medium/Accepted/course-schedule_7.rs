impl Solution {
    pub fn can_finish(num_courses: i32, prerequisites: Vec<Vec<i32>>) -> bool {
        

        let num_courses = num_courses as usize;
        let mut graph = vec![vec![]; num_courses];
        let mut visit = vec![0; num_courses];
        for p in prerequisites {
            graph[p[1] as usize].push(p[0] as usize);
        }
        for i in 0..num_courses {
            if !Solution::dfs(i, &mut visit, &graph) {
                return false;
            }
        }
        true
    }
    
    fn dfs(x: usize, visit: &mut Vec<i32>, graph: &Vec<Vec<usize>>) -> bool {
        if visit[x] == 1 {
            return false;
        }
        if visit[x] == 2 {
            return true;
        }
        visit[x] = 1;
        for &y in &graph[x] {
            if !Solution::dfs(y, visit, graph) {
                return false;
            }
        }
        visit[x] = 2;
        true
    }
}