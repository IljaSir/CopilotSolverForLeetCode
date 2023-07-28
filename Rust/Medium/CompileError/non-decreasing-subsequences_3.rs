impl Solution {
    pub fn find_subsequences(nums: Vec<i32>) -> Vec<Vec<i32>> {
        

        let mut ans = vec![];
        let mut sub = vec![];
        Self::dfs(&nums, &mut ans, &mut sub, 0);
        ans
    }
    fn dfs(nums: &[i32], ans: &mut Vec<Vec<i32>>, sub: &mut Vec<i32>, start: usize) {
        if sub.len() > 1 {
            ans.push(sub.clone());
        }
        let mut used = vec![false; 201];
        for i in start..nums.len() {
            if used[(nums[i] + 100) as usize] {
                continue;
            }
            if sub.is_empty() || sub[sub.len() - 1] <= nums[i] {
                used[(nums[i] + 100) as usize] = true;
                sub.push(nums[i]);
                Self::dfs(nums, ans, sub, i + 1);
                sub.pop();
            }
        }