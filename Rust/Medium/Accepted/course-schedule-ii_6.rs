impl Solution {
    pub fn find_order(num_courses: i32, prerequisites: Vec<Vec<i32>>) -> Vec<i32> {
        

        if prerequisites.is_empty() {
            return (0..num_courses).collect();
        }
        let mut adj = vec![vec![]; num_courses as usize];
        let mut indegree = vec![0; num_courses as usize];
        for p in prerequisites {
            adj[p[1] as usize].push(p[0] as usize);
            indegree[p[0] as usize] += 1;
        }
        let mut q = std::collections::VecDeque::new();
        for (i, &v) in indegree.iter().enumerate() {
            if v == 0 {
                q.push_back(i);
            }
        }
        let mut res = vec![];
        while let Some(v) = q.pop_front() {
            res.push(v as i32);
            for &w in adj[v].iter() {
                indegree[w] -= 1;
                if indegree[w] == 0 {
                    q.push_back(w);
                }
            }
        }
        if res.len() == num_courses as usize {
            res
        } else {
            vec![]
        }
    }
}