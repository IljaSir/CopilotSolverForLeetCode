impl Solution {
    pub fn permute_unique(nums: Vec<i32>) -> Vec<Vec<i32>> {
        

        let mut result = vec![];
        let mut nums = nums;
        nums.sort();
        Self::backtrack(&mut result, &mut nums, 0);
        result
    }
    
    fn backtrack(result: &mut Vec<Vec<i32>>, nums: &mut Vec<i32>, start: usize) {
        if start == nums.len() {
            result.push(nums.to_vec());
        } else {
            for i in start..nums.len() {
                if i != start && nums[i] == nums[start] {
                    continue;
                }
                nums.swap(i, start);
                Self::backtrack(result, nums, start + 1);
                nums.swap(i, start);
            }
        }