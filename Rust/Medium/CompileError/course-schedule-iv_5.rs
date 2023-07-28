impl Solution {
    pub fn check_if_prerequisite(num_courses: i32, prerequisites: Vec<Vec<i32>>, queries: Vec<Vec<i32>>) -> Vec<bool> {
        
        let num_courses = num_courses as usize;
        let mut graph = vec![vec![]; num_courses];
        for [a, b] in prerequisites {
            graph[a as usize].push(b as usize);
        }
        let mut reachable = vec![vec![false; num_courses]; num_courses];
        for node in 0..num_courses {
            let mut queue = vec![];
            queue.push(node);
            while let Some(front) = queue.pop() {
                for &neigh in &graph[front] {
                    if !reachable[node][neigh] {
                        reachable[node][neigh] = true;
                        queue.push(neigh);
                    }
                }
            }
        }
        queries.iter().map(|[a, b]| reachable[*a as usize][*b as usize]).collect()
    }
}