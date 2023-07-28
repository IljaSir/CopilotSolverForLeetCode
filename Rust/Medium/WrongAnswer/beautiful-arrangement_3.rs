impl Solution {
    pub fn count_arrangement(n: i32) -> i32 {
        

        let n = n as usize;
        let mut used = vec![false; n];
        let mut ret = 0;
        Solution::dfs(&mut used, 0, n, &mut ret);
        ret
    }
    fn dfs(used: &mut Vec<bool>, pos: usize, n: usize, ret: &mut i32) {
        if pos == n {
            *ret += 1;
            return;
        }
        for i in 0..n {
            if !used[i] && (i + 1) % (pos + 1) == 0 || (pos + 1) % (i + 1) == 0 {
                used[i] = true;
                Solution::dfs(used, pos + 1, n, ret);
                used[i] = false;
            }
        }
    }
}