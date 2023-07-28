impl Solution {
    pub fn find_min_height_trees(n: i32, edges: Vec<Vec<i32>>) -> Vec<i32> {
        

        let n = n as usize;
        let mut graph = vec![vec![]; n];
        for edge in edges {
            graph[edge[0] as usize].push(edge[1] as usize);
            graph[edge[1] as usize].push(edge[0] as usize);
        }
        let mut leaves = Vec::new();
        for i in 0..n {
            if graph[i].len() == 1 {
                leaves.push(i);
            }
        }
        let mut count = n;
        while count > 2 {
            count -= leaves.len();
            let mut new_leaves = Vec::new();
            for leaf in leaves {
                let neighbor = graph[leaf][0];
                graph[neighbor].retain(|&v| v != leaf);
                if graph[neighbor].len() == 1 {
                    new_leaves.push(neighbor);
                }
            }
            leaves = new_leaves;
        }
        leaves
    }
}