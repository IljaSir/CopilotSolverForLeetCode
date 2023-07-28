impl Solution {
    pub fn subsets_with_dup(nums: Vec<i32>) -> Vec<Vec<i32>> {
        

        let mut result = Vec::new();
        let mut nums = nums;
        nums.sort();
        Self::helper(&mut result, &nums, 0, Vec::new());
        result
    }
    fn helper(result: &mut Vec<Vec<i32>>, nums: &Vec<i32>, start: usize, mut temp: Vec<i32>) {
        result.push(temp.clone());
        for i in start..nums.len() {
            if i > start && nums[i] == nums[i - 1] {
                continue;
            }
            temp.push(nums[i]);
            Self::helper(result, nums, i + 1, temp.clone());
            temp.pop();
        }
    }
}