impl Solution {
    pub fn find_redundant_directed_connection(edges: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut parents = vec![0; edges.len() + 1];
        let mut candidates = vec![];
        let mut conflict = vec![];
        for edge in edges.iter() {
            let u = edge[0] as usize;
            let v = edge[1] as usize;
            if parents[v] != 0 {
                conflict = vec![parents[v], v as i32];
                candidates = vec![u as i32, v as i32];
            } else {
                parents[v] = u;
            }
        }
        for edge in edges.iter() {
            let u = edge[0] as usize;
            let v = edge[1] as usize;
            if conflict != vec![u as i32, v as i32] {
                if Solution::find(&parents, u) == Solution::find(&parents, v) {
                    if conflict.is_empty() {
                        return vec![u as i32, v as i32];
                    } else {
                        return conflict;
                    }
                } else {
                    Solution::union(&mut parents, u, v);
                }
            }
        }
        candidates
    }
    fn find(parents: &Vec<usize>, x: usize) -> usize {
        if parents[x] == 0 {
            x
        } else {
            Solution::find(parents, parents[x])
        }
    }
}