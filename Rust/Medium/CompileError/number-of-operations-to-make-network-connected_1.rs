impl Solution {
    pub fn make_connected(n: i32, connections: Vec<Vec<i32>>) -> i32 {
        
        if connections.len() < n as usize - 1 {
            return -1;
        }
        let mut uf = UnionFind::new(n as usize);
        for connection in connections {
            uf.union(connection[0] as usize, connection[1] as usize);
        }
        let mut count = 0;
        for i in 0..n {
            if uf.find(i as usize) == i as usize {
                count += 1;
            }
        }
        count - 1
    }
}