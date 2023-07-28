impl Solution {
    pub fn combination_sum2(candidates: Vec<i32>, target: i32) -> Vec<Vec<i32>> {
        

        let mut candidates = candidates;
        candidates.sort();
        let mut ans = Vec::new();
        let mut tmp = Vec::new();
        let mut visited = vec![false; candidates.len()];
        Self::dfs(&candidates, target, 0, &mut ans, &mut tmp, &mut visited);
        ans
    }
    fn dfs(candidates: &Vec<i32>, target: i32, start: usize, ans: &mut Vec<Vec<i32>>, tmp: &mut Vec<i32>, visited: &mut Vec<bool>) {
        if target == 0 {
            ans.push(tmp.clone());
            return;
        }
        for i in start..candidates.len() {
            if target - candidates[i] < 0 {
                break;
            }
            if i > 0 && candidates[i] == candidates[i - 1] && !visited[i - 1] {
                continue;
            }
            tmp.push(candidates[i]);
            visited[i] = true;
            Self::dfs(candidates, target - candidates[i], i + 1, ans, tmp, visited);
            tmp.pop();
            visited[i] = false;
        }
    }
}