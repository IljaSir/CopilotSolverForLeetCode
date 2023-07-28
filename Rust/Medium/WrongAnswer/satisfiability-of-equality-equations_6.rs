impl Solution {
    pub fn equations_possible(equations: Vec<String>) -> bool {
        
        let n = equations.len();
        let mut eq = vec![vec![]; 26];
        let mut neq = vec![vec![]; 26];
        for i in 0..n {
            let eqs = equations[i].as_bytes();
            if eqs[1] == b'=' {
                eq[(eqs[0] - b'a') as usize].push((eqs[3] - b'a') as usize);
                eq[(eqs[3] - b'a') as usize].push((eqs[0] - b'a') as usize);
            } else {
                neq[(eqs[0] - b'a') as usize].push((eqs[3] - b'a') as usize);
                neq[(eqs[3] - b'a') as usize].push((eqs[0] - b'a') as usize);
            }
        }
        let mut vis = vec![false; 26];
        for i in 0..26 {
            if !vis[i] {
                if !Self::dfs(i, &mut vis, &eq, &neq) {
                    return false;
                }
            }
        }
        true
    }
    fn dfs(cur: usize, vis: &mut Vec<bool>, eq: &Vec<Vec<usize>>, neq: &Vec<Vec<usize>>) -> bool {
        vis[cur] = true;
        for &i in eq[cur].iter() {
            if !vis[i] {
                if !Self::dfs(i, vis, eq, neq) {
                    return false;
                }
            }
        }
        for &i in neq[cur].iter() {
            if vis[i] {
                return false;
            }
        }
        true
    }
}