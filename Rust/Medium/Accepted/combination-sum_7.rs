impl Solution {
    pub fn combination_sum(candidates: Vec<i32>, target: i32) -> Vec<Vec<i32>> {
        

        let mut result = vec![];
        let mut tmp = vec![];
        let mut candidates = candidates;
        candidates.sort();
        Self::dfs(&candidates, target, 0, &mut tmp, &mut result);
        result
    }

    fn dfs(candidates: &Vec<i32>, target: i32, start: usize, tmp: &mut Vec<i32>, result: &mut Vec<Vec<i32>>) {
        if target < 0 {
            return;
        }
        if target == 0 {
            result.push(tmp.clone());
            return;
        }
        for i in start..candidates.len() {
            if candidates[i] > target {
                break;
            }
            tmp.push(candidates[i]);
            Self::dfs(candidates, target - candidates[i], i, tmp, result);
            tmp.pop();
        }
    }
}