impl Solution {
    pub fn is_possible(n: i32, edges: Vec<Vec<i32>>) -> bool {
        
        let mut odd_degree_nodes = 0;
        let mut adjacency_list = vec![vec![]; n as usize];
        for edge in edges {
            adjacency_list[(edge[0] - 1) as usize].push(edge[1]);
            adjacency_list[(edge[1] - 1) as usize].push(edge[0]);
        }
        for i in 0..n as usize {
            if adjacency_list[i].len() % 2 != 0 {
                odd_degree_nodes += 1;
            }
        }
        odd_degree_nodes <= 2
    }
}