impl Solution {
    pub fn equations_possible(equations: Vec<String>) -> bool {
        
        let mut parent = vec![0; 26];
        for i in 0..26 {
            parent[i] = i;
        }
        for s in equations.iter() {
            if s.as_bytes()[1] == b'=' {
                let a = s.as_bytes()[0] - b'a';
                let b = s.as_bytes()[3] - b'a';
                let pa = Self::find(&mut parent, a as usize);
                let pb = Self::find(&mut parent, b as usize);
                if pa != pb {
                    parent[pa] = pb;
                }
            }
        }
        for s in equations.iter() {
            if s.as_bytes()[1] == b'!' {
                let a = s.as_bytes()[0] - b'a';
                let b = s.as_bytes()[3] - b'a';
                let pa = Self::find(&mut parent, a as usize);
                let pb = Self::find(&mut parent, b as usize);
                if pa == pb {
                    return false;
                }
            }
        }
        true
    }
    fn find(parent: &mut Vec<usize>, i: usize) -> usize {
        if i == parent[i] {
            return i;
        }
        let p = Self::find(parent, parent[i]);
        parent[i] = p;
        p
    }
}