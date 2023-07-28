impl Solution {
    pub fn combination_sum(candidates: Vec<i32>, target: i32) -> Vec<Vec<i32>> {
        

        let mut result = vec![];
        let mut path = vec![];
        let mut candidates = candidates;
        candidates.sort();
        Self::dfs(&candidates, target, 0, &mut path, &mut result);
        result
    }
    fn dfs(candidates: &Vec<i32>, target: i32, start: usize, path: &mut Vec<i32>, result: &mut Vec<Vec<i32>>) {
        if target == 0 {
            result.push(path.to_vec());
            return;
        }
        for i in start..candidates.len() {
            let candidate = candidates[i];
            if candidate > target {
                break;
            }
            path.push(candidate);
            Self::dfs(candidates, target - candidate, i, path, result);
            path.pop();
        }
    }
}