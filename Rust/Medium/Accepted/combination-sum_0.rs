impl Solution {
    pub fn combination_sum(candidates: Vec<i32>, target: i32) -> Vec<Vec<i32>> {
        

        let mut res = Vec::new();
        let mut cur = Vec::new();
        Solution::dfs(&candidates, target, 0, &mut cur, &mut res);
        res
    }
    fn dfs(candidates: &Vec<i32>, target: i32, idx: usize, cur: &mut Vec<i32>, res: &mut Vec<Vec<i32>>) {
        if target == 0 {
            res.push(cur.clone());
            return;
        }
        for i in idx..candidates.len() {
            let v = candidates[i];
            if target - v < 0 {
                continue;
            }
            cur.push(v);
            Solution::dfs(candidates, target - v, i, cur, res);
            cur.pop();
        }
    }
}