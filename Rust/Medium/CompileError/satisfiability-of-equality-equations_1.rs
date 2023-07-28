impl Solution {
    pub fn equations_possible(equations: Vec<String>) -> bool {
        
        let mut uf = UnionFind::new(26);
        for equation in equations.iter() {
            if equation.as_bytes()[1] == b'=' {
                let x = equation.as_bytes()[0] - b'a';
                let y = equation.as_bytes()[3] - b'a';
                uf.union(x as usize, y as usize);
            }
        }
        for equation in equations.iter() {
            if equation.as_bytes()[1] == b'!' {
                let x = equation.as_bytes()[0] - b'a';
                let y = equation.as_bytes()[3] - b'a';
                if uf.connected(x as usize, y as usize) {
                    return false;
                }
            }
        }
        true
    }
}