impl Solution {
    pub fn find_subsequences(nums: Vec<i32>) -> Vec<Vec<i32>> {
        

        let mut result = Vec::new();
        let mut buf = Vec::new();
        Self::dfs(&nums, 0, &mut buf, &mut result);
        result
    }
    
    fn dfs(nums: &[i32], start: usize, buf: &mut Vec<i32>, result: &mut Vec<Vec<i32>>) {
        if buf.len() >= 2 {
            result.push(buf.clone());
        }
        let mut used = [false; 201];
        for i in start..nums.len() {
            if used[(nums[i] + 100) as usize] {
                continue;
            }
            if buf.is_empty() || nums[i] >= *buf.last().unwrap() {
                used[(nums[i] + 100) as usize] = true;
                buf.push(nums[i]);
                Self::dfs(nums, i + 1, buf, result);
                buf.pop();
            }
        }