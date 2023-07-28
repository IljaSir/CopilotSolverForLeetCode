impl Solution {
    pub fn subsets_with_dup(nums: Vec<i32>) -> Vec<Vec<i32>> {
        

        let mut result = Vec::new();
        let mut nums = nums;
        nums.sort();
        Self::helper(&mut result, &mut Vec::new(), &nums, 0);
        result
    }
    fn helper(result: &mut Vec<Vec<i32>>, tmp: &mut Vec<i32>, nums: &Vec<i32>, start: usize) {
        result.push(tmp.clone());
        for i in start..nums.len() {
            if i > start && nums[i] == nums[i - 1] {
                continue;
            }
            tmp.push(nums[i]);
            Self::helper(result, tmp, nums, i + 1);
            tmp.pop();
        }
    }
}