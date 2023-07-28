impl Solution {
    pub fn permute_unique(nums: Vec<i32>) -> Vec<Vec<i32>> {
        

        let mut nums = nums;
        nums.sort();
        let mut res = Vec::new();
        let mut used = vec![false; nums.len()];
        let mut path = Vec::new();
        Self::dfs(&nums, &mut used, &mut path, &mut res);
        res
    }

    fn dfs(nums: &Vec<i32>, used: &mut Vec<bool>, path: &mut Vec<i32>, res: &mut Vec<Vec<i32>>) {
        let n = nums.len();
        if path.len() == n {
            res.push(path.clone());
            return;
        }
        for i in 0..n {
            if used[i] {
                continue;
            }
            if i > 0 && nums[i] == nums[i - 1] && !used[i - 1] {
                continue;
            }
            path.push(nums[i]);
            used[i] = true;
            Self::dfs(nums, used, path, res);
            used[i] = false;
            path.pop();
        }
    }
}