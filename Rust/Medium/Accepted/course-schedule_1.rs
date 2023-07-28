impl Solution {
    pub fn can_finish(num_courses: i32, prerequisites: Vec<Vec<i32>>) -> bool {
        

        let mut graph = vec![vec![]; num_courses as usize];
        let mut in_degrees = vec![0; num_courses as usize];
        for p in prerequisites {
            graph[p[1] as usize].push(p[0] as usize);
            in_degrees[p[0] as usize] += 1;
        }
        let mut queue = Vec::new();
        for i in 0..num_courses {
            if in_degrees[i as usize] == 0 {
                queue.push(i as usize);
            }
        }
        let mut count = 0;
        while let Some(i) = queue.pop() {
            count += 1;
            for j in &graph[i] {
                in_degrees[*j] -= 1;
                if in_degrees[*j] == 0 {
                    queue.push(*j);
                }
            }
        }
        count == num_courses
    }
}