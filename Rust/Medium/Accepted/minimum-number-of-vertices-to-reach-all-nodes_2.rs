impl Solution {
    pub fn find_smallest_set_of_vertices(n: i32, edges: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut in_degree: Vec<i32> = vec![0; n as usize];
        for edge in edges {
            in_degree[edge[1] as usize] += 1;
        }
        let mut res: Vec<i32> = Vec::new();
        for i in 0..n {
            if in_degree[i as usize] == 0 {
                res.push(i);
            }
        }
        res
    }
}