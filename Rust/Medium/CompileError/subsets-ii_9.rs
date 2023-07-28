impl Solution {
    pub fn subsets_with_dup(nums: Vec<i32>) -> Vec<Vec<i32>> {
        

        let mut result = Vec::new();
        let mut nums = nums;
        nums.sort();
        Self::subsets_with_dup_rec(&nums, &mut result, Vec::new(), 0);
        result
    }
    fn subsets_with_dup_rec(nums: &Vec<i32>, result: &mut Vec<Vec<i32>>, mut current: Vec<i32>, start: usize) {
        result.push(current);
        for i in start..nums.len() {
            if i > start && nums[i] == nums[i-1] {
                continue;
            }
            current.push(nums[i]);
            Self::subsets_with_dup_rec(nums, result, current.clone(), i+1);
            current.pop();
        }
    }
}