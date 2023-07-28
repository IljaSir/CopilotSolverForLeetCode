impl Solution {
    pub fn make_connected(n: i32, connections: Vec<Vec<i32>>) -> i32 {
        
        if connections.len() < n as usize - 1 {
            return -1;
        }
        let mut uf = UnionFind::new(n as usize);
        for c in connections {
            uf.union(c[0] as usize, c[1] as usize);
        }
        uf.count() - 1
    }
}