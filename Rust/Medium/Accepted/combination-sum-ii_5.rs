impl Solution {
    pub fn combination_sum2(candidates: Vec<i32>, target: i32) -> Vec<Vec<i32>> {
        

        let mut candidates = candidates;
        candidates.sort();
        let mut ret = vec![];
        let mut tmp = vec![];
        Self::dfs(&candidates, target, 0, &mut tmp, &mut ret);
        ret
    }
    fn dfs(candidates: &Vec<i32>, target: i32, start: usize, tmp: &mut Vec<i32>, ret: &mut Vec<Vec<i32>>) {
        if target == 0 {
            ret.push(tmp.clone());
            return;
        }
        for i in start..candidates.len() {
            if i > start && candidates[i] == candidates[i-1] {
                continue;
            }
            if target - candidates[i] < 0 {
                break;
            }
            tmp.push(candidates[i]);
            Self::dfs(candidates, target - candidates[i], i+1, tmp, ret);
            tmp.pop();
        }
    }
}