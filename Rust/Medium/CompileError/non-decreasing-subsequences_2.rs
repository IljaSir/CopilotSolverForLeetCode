impl Solution {
    pub fn find_subsequences(nums: Vec<i32>) -> Vec<Vec<i32>> {
        

        let mut res = vec![];
        let mut seq = vec![];
        Self::dfs(&nums, 0, &mut seq, &mut res);
        res
    }
    
    fn dfs(nums: &[i32], start: usize, seq: &mut Vec<i32>, res: &mut Vec<Vec<i32>>) {
        if seq.len() >= 2 {
            res.push(seq.clone());
        }
        let mut used = std::collections::HashSet::new();
        for i in start..nums.len() {
            if used.contains(&nums[i]) {
                continue;
            }
            if seq.is_empty() || seq.last().unwrap() <= &nums[i] {
                seq.push(nums[i]);
                used.insert(nums[i]);
                Self::dfs(nums, i + 1, seq, res);
                seq.pop();
            }
        }