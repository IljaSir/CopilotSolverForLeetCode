impl Solution {
    pub fn find_order(num_courses: i32, prerequisites: Vec<Vec<i32>>) -> Vec<i32> {
        

        let mut in_degree = vec![0; num_courses as usize];
        let mut neighbors = vec![vec![]; num_courses as usize];
        for pair in prerequisites {
            in_degree[pair[0] as usize] += 1;
            neighbors[pair[1] as usize].push(pair[0]);
        }
        let mut res = Vec::new();
        let mut queue = std::collections::VecDeque::new();
        for i in 0..num_courses {
            if in_degree[i as usize] == 0 {
                queue.push_back(i);
            }
        }
        while let Some(course) = queue.pop_front() {
            res.push(course);
            for &n in &neighbors[course as usize] {
                in_degree[n as usize] -= 1;
                if in_degree[n as usize] == 0 {
                    queue.push_back(n);
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