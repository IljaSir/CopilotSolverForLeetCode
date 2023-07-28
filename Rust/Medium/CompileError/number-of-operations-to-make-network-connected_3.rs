impl Solution {
    pub fn make_connected(n: i32, connections: Vec<Vec<i32>>) -> i32 {
        
        let n = n as usize;
        let mut uf = UnionFind::new(n);
        let mut extra = 0;
        for conn in connections {
            if uf.union(conn[0] as usize, conn[1] as usize) {
                extra += 1;
            }
        }
        let mut cnt = 0;
        for i in 0..n {
            if uf.find(i) == i {
                cnt += 1;
            }
        }
        if cnt > extra + 1 {
            return -1;
        }
        cnt as i32 - 2
    }
}