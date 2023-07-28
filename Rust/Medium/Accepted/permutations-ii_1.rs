impl Solution {
    pub fn permute_unique(nums: Vec<i32>) -> Vec<Vec<i32>> {
        

        let mut nums = nums;
        nums.sort();
        let mut res = Vec::new();
        let mut used = vec![false; nums.len()];
        let mut path = Vec::new();
        Self::dfs(&mut res, &mut used, &mut path, &nums);
        res
    }
    fn dfs(res: &mut Vec<Vec<i32>>, used: &mut Vec<bool>, path: &mut Vec<i32>, nums: &[i32]) {
        if path.len() == nums.len() {
            res.push(path.clone());
            return;
        }
        for i in 0..nums.len() {
            if used[i] {
                continue;
            }
            if i > 0 && nums[i] == nums[i - 1] && !used[i - 1] {
                continue;
            }
            used[i] = true;
            path.push(nums[i]);
            Self::dfs(res, used, path, nums);
            path.pop();
            used[i] = false;
        }
    }
}