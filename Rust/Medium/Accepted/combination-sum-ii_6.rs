impl Solution {
    pub fn combination_sum2(candidates: Vec<i32>, target: i32) -> Vec<Vec<i32>> {
        

        let mut candidates = candidates;
        candidates.sort();
        let mut ans = vec![];
        let mut path = vec![];
        let mut used = vec![false; candidates.len()];
        Self::dfs(&candidates, target, 0, &mut used, &mut path, &mut ans);
        ans
    }

    fn dfs(candidates: &Vec<i32>, target: i32, start: usize, used: &mut Vec<bool>, path: &mut Vec<i32>, ans: &mut Vec<Vec<i32>>) {
        if target == 0 {
            ans.push(path.clone());
            return;
        }
        let mut last = -1;
        for i in start..candidates.len() {
            if used[i] { continue; }
            if last == candidates[i] { continue; }
            if candidates[i] > target { break; }
            last = candidates[i];
            used[i] = true;
            path.push(candidates[i]);
            Self::dfs(candidates, target - candidates[i], i + 1, used, path, ans);
            path.pop();
            used[i] = false;
        }
    }
}