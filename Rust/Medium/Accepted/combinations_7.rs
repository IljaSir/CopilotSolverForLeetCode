impl Solution {
    pub fn combine(n: i32, k: i32) -> Vec<Vec<i32>> {
        

        let mut res = Vec::new();
        let mut nums = Vec::new();
        for i in 1..=n {
            nums.push(i);
        }
        let mut tmp = Vec::new();
        Self::dfs(&mut res, &mut tmp, &nums, k as usize);
        res
    }
    fn dfs(res: &mut Vec<Vec<i32>>, tmp: &mut Vec<i32>, nums: &[i32], k: usize) {
        if tmp.len() == k {
            res.push(tmp.clone());
            return;
        }
        for i in 0..nums.len() {
            tmp.push(nums[i]);
            Self::dfs(res, tmp, &nums[i + 1..], k);
            tmp.pop();
        }
    }
}