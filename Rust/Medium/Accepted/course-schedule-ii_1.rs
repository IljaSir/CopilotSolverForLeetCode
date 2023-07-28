impl Solution {
    pub fn find_order(num_courses: i32, prerequisites: Vec<Vec<i32>>) -> Vec<i32> {
        

        let mut graph = vec![vec![]; num_courses as usize];
        let mut in_degree = vec![0; num_courses as usize];
        for edge in prerequisites {
            graph[edge[1] as usize].push(edge[0] as usize);
            in_degree[edge[0] as usize] += 1;
        }
        let mut queue = Vec::new();
        for i in 0..num_courses {
            if in_degree[i as usize] == 0 {
                queue.push(i);
            }
        }
        let mut res = Vec::new();
        while !queue.is_empty() {
            let node = queue.remove(0);
            res.push(node);
            for &i in &graph[node as usize] {
                in_degree[i] -= 1;
                if in_degree[i] == 0 {
                    queue.push(i as i32);
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