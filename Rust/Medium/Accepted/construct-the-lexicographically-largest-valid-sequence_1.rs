impl Solution {
    pub fn construct_distanced_sequence(n: i32) -> Vec<i32> {
        
        let mut res = vec![0; 2 * n as usize - 1];
        let mut used = vec![false; n as usize + 1];
        Self::dfs(0, n, &mut res, &mut used);
        res
    }
    fn dfs(pos: usize, n: i32, res: &mut Vec<i32>, used: &mut Vec<bool>) -> bool {
        if pos == res.len() {
            return true;
        }
        if res[pos] > 0 {
            return Self::dfs(pos + 1, n, res, used);
        }
        for i in (1..=n).rev() {
            if used[i as usize] {
                continue;
            }
            if i > 1 && (pos + i as usize >= res.len() || res[pos + i as usize] > 0) {
                continue;
            }
            res[pos] = i;
            used[i as usize] = true;
            if i > 1 {
                res[pos + i as usize] = i;
            }
            if Self::dfs(pos + 1, n, res, used) {
                return true;
            }
            res[pos] = 0;
            used[i as usize] = false;
            if i > 1 {
                res[pos + i as usize] = 0;
            }
        }
        false
    }
}