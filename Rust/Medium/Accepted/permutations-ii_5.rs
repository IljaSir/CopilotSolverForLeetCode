impl Solution {
    pub fn permute_unique(nums: Vec<i32>) -> Vec<Vec<i32>> {
        

        let mut res = vec![];
        let mut nums = nums;
        nums.sort();
        let mut visited = vec![false; nums.len()];
        let mut path = vec![];
        Self::backtrack(&nums, &mut visited, &mut path, &mut res);
        res
    }
    fn backtrack(nums: &Vec<i32>, visited: &mut Vec<bool>, path: &mut Vec<i32>, res: &mut Vec<Vec<i32>>) {
        if path.len() == nums.len() {
            res.push(path.clone());
            return;
        }
        for i in 0..nums.len() {
            if visited[i] { continue; }
            if i > 0 && nums[i] == nums[i - 1] && !visited[i - 1] { continue; }
            visited[i] = true;
            path.push(nums[i]);
            Self::backtrack(nums, visited, path, res);
            path.pop();
            visited[i] = false;
        }
    }
}