impl Solution {
    pub fn combination_sum(candidates: Vec<i32>, target: i32) -> Vec<Vec<i32>> {
        

        let mut result: Vec<Vec<i32>> = vec![];
        Self::dfs(&candidates, target, 0, &mut vec![], &mut result);
        result
    }
    fn dfs(candidates: &Vec<i32>, target: i32, index: usize, path: &mut Vec<i32>, result: &mut Vec<Vec<i32>>) {
        if target < 0 {
            return;
        }
        if target == 0 {
            result.push(path.clone());
            return;
        }
        for i in index..candidates.len() {
            path.push(candidates[i]);
            Self::dfs(candidates, target - candidates[i], i, path, result);
            path.pop();
        }
    }
}