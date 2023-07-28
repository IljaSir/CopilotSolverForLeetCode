impl Solution {
    pub fn find_unsorted_subarray(nums: Vec<i32>) -> i32 {
        

        let mut nums = nums;
        let mut snums = nums.clone();
        snums.sort();
        let mut i = 0;
        while i < nums.len() {
            if nums[i] != snums[i] {
                break;
            }
            i += 1;
        }
        if i == nums.len() {
            return 0;
        }
        let mut j = nums.len() - 1;
        while j >= i {
            if nums[j] != snums[j] {
                break;
            }
            j -= 1;
        }
        (j - i + 1) as i32
    }
}