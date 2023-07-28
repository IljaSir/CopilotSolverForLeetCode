impl Solution {
    pub fn majority_element(nums: Vec<i32>) -> Vec<i32> {
        

        let mut nums = nums;
        nums.sort();
        let mut res = Vec::new();
        let mut i = 0;
        while i < nums.len() {
            let mut j = i + 1;
            while j < nums.len() && nums[j] == nums[i] {
                j += 1;
            }
            if j - i > nums.len() / 3 {
                res.push(nums[i]);
            }
            i = j;
        }
        res
    }
}