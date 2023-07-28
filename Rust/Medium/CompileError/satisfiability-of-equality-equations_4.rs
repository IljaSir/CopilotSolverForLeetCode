impl Solution {
    pub fn equations_possible(equations: Vec<String>) -> bool {
        
        let mut uf = UnionFind::new(26);
        for equation in equations.iter() {
            if equation.as_bytes()[1] == '=' as u8 {
                let a = equation.as_bytes()[0] - 'a' as u8;
                let b = equation.as_bytes()[3] - 'a' as u8;
                uf.union(a as usize, b as usize);
            }
        }
        for equation in equations.iter() {
            if equation.as_bytes()[1] == '!' as u8 {
                let a = equation.as_bytes()[0] - 'a' as u8;
                let b = equation.as_bytes()[3] - 'a' as u8;
                if uf.find(a as usize) == uf.find(b as usize) {
                    return false;
                }
            }
        }
        true
    }
}