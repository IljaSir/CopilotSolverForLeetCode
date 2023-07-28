impl Solution {
    pub fn combination_sum2(candidates: Vec<i32>, target: i32) -> Vec<Vec<i32>> {
        

        let mut candidates = candidates;
        candidates.sort();
        let mut res = Vec::new();
        Self::dfs(&candidates, target, 0, &mut Vec::new(), &mut res);
        res
    }
    fn dfs(candidates: &[i32], target: i32, start: usize, cur: &mut Vec<i32>, res: &mut Vec<Vec<i32>>) {
        if target == 0 {
            res.push(cur.clone());
            return;
        }
        for i in start..candidates.len() {
            if target < candidates[i] {
                break;
            }
            if i > start && candidates[i] == candidates[i - 1] {
                continue;
            }
            cur.push(candidates[i]);
            Self::dfs(candidates, target - candidates[i], i + 1, cur, res);
            cur.pop();
        }
    }
}