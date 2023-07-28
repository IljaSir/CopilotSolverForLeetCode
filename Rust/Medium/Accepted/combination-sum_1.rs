impl Solution {
    pub fn combination_sum(candidates: Vec<i32>, target: i32) -> Vec<Vec<i32>> {
        

        let mut ans = Vec::new();
        let mut path = Vec::new();
        Self::backtrack(&candidates, target, 0, &mut path, &mut ans);
        ans
    }

    fn backtrack(candidates: &Vec<i32>, target: i32, start: usize, path: &mut Vec<i32>, ans: &mut Vec<Vec<i32>>) {
        if target == 0 {
            ans.push(path.clone());
            return;
        }
        for i in start..candidates.len() {
            let cand = candidates[i];
            if target - cand < 0 {
                continue;
            }
            path.push(cand);
            Self::backtrack(candidates, target - cand, i, path, ans);
            path.pop();
        }
    }
}