impl Solution {
    pub fn permute(nums: Vec<i32>) -> Vec<Vec<i32>> {
        

        let mut nums = nums;
        let mut res = vec![];
        let mut used = vec![false; nums.len()];
        let mut path = vec![];
        Self::backtrack(&mut nums, &mut used, &mut path, &mut res);
        res
    }
    fn backtrack(nums: &mut Vec<i32>, used: &mut Vec<bool>, path: &mut Vec<i32>, res: &mut Vec<Vec<i32>>) {
        if path.len() == nums.len() {
            res.push(path.clone());
            return;
        }
        for i in 0..nums.len() {
            if !used[i] {
                used[i] = true;
                path.push(nums[i]);
                Self::backtrack(nums, used, path, res);
                path.pop();
                used[i] = false;
            }
        }
    }
}