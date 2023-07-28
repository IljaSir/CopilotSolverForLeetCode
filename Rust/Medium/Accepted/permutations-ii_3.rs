impl Solution {
    pub fn permute_unique(nums: Vec<i32>) -> Vec<Vec<i32>> {
        

        let mut nums = nums;
        nums.sort();
        let mut res = vec![];
        let mut used = vec![false; nums.len()];
        let mut path = vec![];
        Self::dfs(&mut res, &mut path, &mut used, &nums);
        res
    }
    
    fn dfs(res: &mut Vec<Vec<i32>>, path: &mut Vec<i32>, used: &mut Vec<bool>, nums: &Vec<i32>) {
        if path.len() == nums.len() {
            res.push(path.clone());
            return;
        }
        for i in 0..nums.len() {
            if used[i] || (i > 0 && nums[i] == nums[i-1] && !used[i-1]) {
                continue;
            }
            used[i] = true;
            path.push(nums[i]);
            Self::dfs(res, path, used, nums);
            path.pop();
            used[i] = false;
        }
    }
}