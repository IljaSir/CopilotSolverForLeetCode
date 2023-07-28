impl Solution {
    pub fn rearrange_array(nums: Vec<i32>) -> Vec<i32> {
        
        let mut nums = nums;
        nums.sort_unstable();
        let mut i = 1;
        while i + 1 < nums.len() {
            nums.swap(i, i + 1);
            i += 2;
        }
        nums
    }
}