impl Solution {
    pub fn equations_possible(equations: Vec<String>) -> bool {
        
        let mut uf = UnionFind::new(26);
        for eq in equations.iter() {
            if eq.as_bytes()[1] == b'=' {
                let a = (eq.as_bytes()[0] - b'a') as usize;
                let b = (eq.as_bytes()[3] - b'a') as usize;
                uf.union(a, b);
            }
        }
        for eq in equations.iter() {
            if eq.as_bytes()[1] == b'!' {
                let a = (eq.as_bytes()[0] - b'a') as usize;
                let b = (eq.as_bytes()[3] - b'a') as usize;
                if uf.find(a) == uf.find(b) {
                    return false;
                }
            }
        }
        true
    }
}