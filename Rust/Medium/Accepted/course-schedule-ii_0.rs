impl Solution {
    pub fn find_order(num_courses: i32, prerequisites: Vec<Vec<i32>>) -> Vec<i32> {
        

        let mut graph = vec![vec![]; num_courses as usize];
        let mut indegree = vec![0; num_courses as usize];
        for p in prerequisites {
            graph[p[1] as usize].push(p[0]);
            indegree[p[0] as usize] += 1;
        }
        let mut ans = Vec::with_capacity(num_courses as usize);
        let mut stack = Vec::with_capacity(num_courses as usize);
        for i in 0..num_courses {
            if indegree[i as usize] == 0 {
                stack.push(i);
            }
        }
        while let Some(node) = stack.pop() {
            ans.push(node);
            for &v in &graph[node as usize] {
                indegree[v as usize] -= 1;
                if indegree[v as usize] == 0 {
                    stack.push(v);
                }
            }
        }
        if ans.len() == num_courses as usize {
            ans
        } else {
            vec![]
        }
    }
}