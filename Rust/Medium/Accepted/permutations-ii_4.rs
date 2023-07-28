impl Solution {
    pub fn permute_unique(nums: Vec<i32>) -> Vec<Vec<i32>> {
        

        let mut nums = nums;
        nums.sort_unstable();
        let mut result = Vec::new();
        let mut used = vec![false; nums.len()];
        let mut path = Vec::new();
        Self::backtrack(&mut nums, &mut used, &mut path, &mut result);
        result
    }

    fn backtrack(
        nums: &mut Vec<i32>,
        used: &mut Vec<bool>,
        path: &mut Vec<i32>,
        result: &mut Vec<Vec<i32>>,
    ) {
        if path.len() == nums.len() {
            result.push(path.clone());
            return;
        }
        for i in 0..nums.len() {
            if used[i] {
                continue;
            }
            if i > 0 && nums[i] == nums[i - 1] && !used[i - 1] {
                continue;
            }
            used[i] = true;
            path.push(nums[i]);
            Self::backtrack(nums, used, path, result);
            path.pop();
            used[i] = false;
        }
    }
}