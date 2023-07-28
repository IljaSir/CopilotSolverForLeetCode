impl Solution {
    pub fn can_finish(num_courses: i32, prerequisites: Vec<Vec<i32>>) -> bool {
        

        let mut graph = vec![vec![]; num_courses as usize];
        let mut in_degree = vec![0; num_courses as usize];
        for p in prerequisites {
            graph[p[1] as usize].push(p[0]);
            in_degree[p[0] as usize] += 1;
        }
        let mut queue = std::collections::VecDeque::new();
        for (i, &d) in in_degree.iter().enumerate() {
            if d == 0 {
                queue.push_back(i);
            }
        }
        let mut cnt = 0;
        while let Some(v) = queue.pop_front() {
            cnt += 1;
            for &w in graph[v].iter() {
                in_degree[w as usize] -= 1;
                if in_degree[w as usize] == 0 {
                    queue.push_back(w as usize);
                }
            }
        }
        cnt == num_courses
    }
}