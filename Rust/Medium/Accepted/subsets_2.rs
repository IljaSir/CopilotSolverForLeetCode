impl Solution {
    pub fn subsets(nums: Vec<i32>) -> Vec<Vec<i32>> {
        

        let mut result = Vec::new();
        let mut current = Vec::new();
        Self::dfs(&nums, 0, &mut current, &mut result);
        result
    }
    
    fn dfs(nums: &Vec<i32>, start: usize, current: &mut Vec<i32>, result: &mut Vec<Vec<i32>>) {
        result.push(current.to_vec());
        for i in start..nums.len() {
            current.push(nums[i]);
            Self::dfs(nums, i + 1, current, result);
            current.pop();
        }
    }
}