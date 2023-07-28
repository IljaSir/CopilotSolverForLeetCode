impl Solution {
    pub fn find_min_height_trees(n: i32, edges: Vec<Vec<i32>>) -> Vec<i32> {
        

        let n = n as usize;
        let mut degrees = vec![0; n];
        let mut edges = edges;
        let mut graph = vec![vec![]; n];
        for edge in edges.iter_mut() {
            let (a, b) = (edge[0] as usize, edge[1] as usize);
            degrees[a] += 1;
            degrees[b] += 1;
            graph[a].push(b);
            graph[b].push(a);
        }
        let mut leaves = vec![];
        for i in 0..n {
            if degrees[i] == 1 {
                leaves.push(i);
            }
        }
        let mut remain = n;
        while remain > 2 {
            remain -= leaves.len();
            let mut new_leaves = vec![];
            for leaf in leaves {
                degrees[leaf] -= 1;
                for &node in graph[leaf].iter() {
                    degrees[node] -= 1;
                    if degrees[node] == 1 {
                        new_leaves.push(node);
                    }
                }
            }
            leaves = new_leaves;
        }
        leaves
    }
}