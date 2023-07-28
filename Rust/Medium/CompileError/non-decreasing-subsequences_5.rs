impl Solution {
    pub fn find_subsequences(nums: Vec<i32>) -> Vec<Vec<i32>> {
        

        let mut res = vec![];
        let mut path = vec![];
        let mut used = vec![false; nums.len()];
        Self::dfs(nums.as_slice(), &mut path, &mut res, &mut used);
        res
    }
    fn dfs(nums: &[i32], path: &mut Vec<i32>, res: &mut Vec<Vec<i32>>, used: &mut Vec<bool>) {
        if path.len() >= 2 {
            res.push(path.clone());
        }
        let mut used_val = vec![];
        for i in 0..nums.len() {
            if used[i] || (!used_val.is_empty() && nums[i] == used_val[used_val.len() - 1]) {
                continue;
            }
            if path.is_empty() || nums[i] >= path[path.len() - 1] {
                path.push(nums[i]);
                used[i] = true;
                used_val.push(nums[i]);
                Self::dfs(nums, path, res, used);
                path.pop();
                used[i] = false;
            }
        }