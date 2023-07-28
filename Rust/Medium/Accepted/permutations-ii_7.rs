impl Solution {
    pub fn permute_unique(nums: Vec<i32>) -> Vec<Vec<i32>> {
        

        let mut nums = nums;
        nums.sort();
        let mut res = vec![];
        let mut visited = vec![0; nums.len()];
        fn backtrack(nums: &mut Vec<i32>, visited: &mut Vec<i32>, path: &mut Vec<i32>, res: &mut Vec<Vec<i32>>) {
            if path.len() == nums.len() {
                res.push(path.clone());
                return;
            }
            for i in 0..nums.len() {
                if visited[i] == 1 {
                    continue;
                }
                if i > 0 && nums[i] == nums[i - 1] && visited[i - 1] == 0 {
                    continue;
                }
                visited[i] = 1;
                path.push(nums[i]);
                backtrack(nums, visited, path, res);
                visited[i] = 0;
                path.pop();
            }
        }
        backtrack(&mut nums, &mut visited, &mut vec![], &mut res);
        res
    }
}