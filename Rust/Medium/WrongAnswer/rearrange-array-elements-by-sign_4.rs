impl Solution {
    pub fn rearrange_array(nums: Vec<i32>) -> Vec<i32> {
        
        let mut nums = nums;
        nums.sort_by_key(|&x| x.abs());
        let mut i = 1;
        while i < nums.len() - 1 {
            nums.swap(i, i + 1);
            i += 2;
        }
        nums
    }
}