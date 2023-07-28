impl Solution {
    pub fn permute(nums: Vec<i32>) -> Vec<Vec<i32>> {
        

        let mut result = Vec::new();
        Self::helper(&nums, &mut result, 0);
        result
    }
    
    fn helper(nums: &[i32], result: &mut Vec<Vec<i32>>, i: usize) {
        if i == nums.len() - 1 {
            result.push(nums.to_vec());
        } else {
            for j in i..nums.len() {
                let mut nums = nums.to_vec();
                nums.swap(i, j);
                Self::helper(&nums, result, i + 1);
            }
        }
    }
}