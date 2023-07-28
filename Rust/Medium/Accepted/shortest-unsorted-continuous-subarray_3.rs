impl Solution {
    pub fn find_unsorted_subarray(nums: Vec<i32>) -> i32 {
        

        let mut sorted_nums = nums.clone();
        sorted_nums.sort();
        let mut start = -1;
        let mut end = -1;
        for i in 0..nums.len() {
            if nums[i] != sorted_nums[i] {
                start = i as i32;
                break;
            }
        }
        if start == -1 {
            return 0;
        }
        for i in (0..nums.len()).rev() {
            if nums[i] != sorted_nums[i] {
                end = i as i32;
                break;
            }
        }
        end - start + 1
    }
}