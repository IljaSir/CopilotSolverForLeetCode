impl Solution {
    pub fn equations_possible(equations: Vec<String>) -> bool {
        
        let mut uf = UnionFind::new(26);
        for eq in &equations {
            if eq.as_bytes()[1] == b'=' {
                let i = eq.as_bytes()[0] - b'a';
                let j = eq.as_bytes()[3] - b'a';
                uf.union(i as usize, j as usize);
            }
        }
        for eq in &equations {
            if eq.as_bytes()[1] == b'!' {
                let i = eq.as_bytes()[0] - b'a';
                let j = eq.as_bytes()[3] - b'a';
                if uf.connected(i as usize, j as usize) {
                    return false;
                }
            }
        }
        true
    }
}