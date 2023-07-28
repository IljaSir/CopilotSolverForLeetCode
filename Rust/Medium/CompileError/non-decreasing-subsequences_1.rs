impl Solution {
    pub fn find_subsequences(nums: Vec<i32>) -> Vec<Vec<i32>> {
        

        let mut res = Vec::new();
        let mut path = Vec::new();
        Self::backtrack(&nums, 0, &mut path, &mut res);
        res
    }
    fn backtrack(nums: &Vec<i32>, start: usize, path: &mut Vec<i32>, res: &mut Vec<Vec<i32>>) {
        if path.len() >= 2 {
            res.push(path.clone());
        }
        let mut used = Vec::new();
        for i in start..nums.len() {
            if used.contains(&nums[i]) {
                continue;
            }
            if path.is_empty() || path[path.len() - 1] <= nums[i] {
                path.push(nums[i]);
                used.push(nums[i]);
                Self::backtrack(nums, i + 1, path, res);
                path.pop();
            }
        }