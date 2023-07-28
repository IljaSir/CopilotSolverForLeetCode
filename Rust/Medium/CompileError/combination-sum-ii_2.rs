impl Solution {
    pub fn combination_sum2(candidates: Vec<i32>, target: i32) -> Vec<Vec<i32>> {
        

        let mut candidates = candidates;
        candidates.sort();
        let mut res = Vec::new();
        Solution::dfs(&candidates, target, 0, &mut Vec::new(), &mut res);
        res
    }
    fn dfs(candidates: &Vec<i32>, target: i32, start: usize, tmp: &mut Vec<i32>, res: &mut Vec<Vec<i32>>) {
        if target < 0 {
            return
        }
        if target == 0 {
            res.push(tmp.clone());
        } else {
            for i in start..candidates.len() {
                if i > start && candidates[i] == candidates[i-1] {
                    continue;
                }
                tmp.push(candidates[i]);
                Solution::dfs(candidates, target-candidates[i], i+1, tmp, res);
                tmp.pop();
            }
        }