impl Solution {
    pub fn find_lonely(nums: Vec<i32>) -> Vec<i32> {
        
        let mut res = vec![];
        let mut i = 0;
        while i < nums.len() {
            if i == nums.len() - 1 || nums[i] != nums[i + 1] {
                res.push(nums[i]);
            } else {
                i += 1;
            }
            i += 1;
        }
        res
    }
}