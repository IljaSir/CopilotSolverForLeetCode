impl Solution {
    pub fn permute_unique(nums: Vec<i32>) -> Vec<Vec<i32>> {
        

        let mut nums = nums;
        let mut result = vec![];
        nums.sort();
        let mut visited = vec![false; nums.len()];
        let mut path = vec![];
        Self::backtrack(&mut nums, &mut path, &mut visited, &mut result);
        result
    }
    
    fn backtrack(nums: &mut Vec<i32>, path: &mut Vec<i32>, visited: &mut Vec<bool>, result: &mut Vec<Vec<i32>>) {
        if path.len() == nums.len() {
            result.push(path.clone());
            return;
        }
        
        for i in 0..nums.len() {
            if visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            path.push(nums[i]);
            Self::backtrack(nums, path, visited, result);
            path.pop();
            visited[i] = false;
        }
    }
}