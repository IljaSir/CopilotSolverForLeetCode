impl Solution {
    pub fn subsets_with_dup(nums: Vec<i32>) -> Vec<Vec<i32>> {
        

        let mut nums = nums;
        nums.sort_unstable();
        let mut ans = vec![vec![]];
        let mut cur = vec![];
        Self::dfs(&mut ans, &mut cur, &nums, 0);
        ans
    }
    fn dfs(ans: &mut Vec<Vec<i32>>, cur: &mut Vec<i32>, nums: &[i32], idx: usize) {
        if idx == nums.len() {
            return;
        }
        for i in idx..nums.len() {
            if i > idx && nums[i] == nums[i - 1] {
                continue;
            }
            cur.push(nums[i]);
            ans.push(cur.clone());
            Self::dfs(ans, cur, nums, i + 1);
            cur.pop();
        }
    }
}