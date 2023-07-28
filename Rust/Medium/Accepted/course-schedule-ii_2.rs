impl Solution {
    pub fn find_order(num_courses: i32, prerequisites: Vec<Vec<i32>>) -> Vec<i32> {
        

        let mut graph = vec![vec![]; num_courses as usize];
        let mut in_degree = vec![0; num_courses as usize];
        for edge in prerequisites {
            graph[edge[1] as usize].push(edge[0]);
            in_degree[edge[0] as usize] += 1;
        }
        let mut queue = vec![];
        for i in 0..in_degree.len() {
            if in_degree[i] == 0 {
                queue.push(i as i32);
            }
        }
        let mut res = vec![];
        while !queue.is_empty() {
            let v = queue.pop().unwrap();
            res.push(v);
            for &w in &graph[v as usize] {
                in_degree[w as usize] -= 1;
                if in_degree[w as usize] == 0 {
                    queue.push(w);
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