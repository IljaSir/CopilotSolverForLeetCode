impl Solution {
    pub fn find_smallest_set_of_vertices(n: i32, edges: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut res = vec![false; n as usize];
        for e in edges {
            res[e[1] as usize] = true;
        }
        res.into_iter().enumerate().filter(|(_, v)| !v).map(|(i, _)| i as i32).collect()
    }
}