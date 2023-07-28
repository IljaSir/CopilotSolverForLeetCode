impl Solution {
    pub fn count_arrangement(n: i32) -> i32 {
        

        let mut nums = (1..=n).collect::<Vec<i32>>();
        Self::dfs(&mut nums, 0)
    }
    fn dfs(nums: &mut Vec<i32>, k: usize) -> i32 {
        if k == nums.len() {
            return 1;
        }
        let mut res = 0;
        for i in k..nums.len() {
            if nums[i] % (k + 1) as i32 == 0 || (k + 1) as i32 % nums[i] == 0 {
                nums.swap(i, k);
                res += Self::dfs(nums, k + 1);
                nums.swap(i, k);
            }
        }
        res
    }
}