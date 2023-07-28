impl Solution {
    pub fn find_unsorted_subarray(nums: Vec<i32>) -> i32 {
        

        let mut sorted = nums.clone();
        sorted.sort();
        let mut start = 0;
        let mut end = 0;
        for i in 0..nums.len() {
            if nums[i] != sorted[i] {
                start = i;
                break;
            }
        }
        for i in (0..nums.len()).rev() {
            if nums[i] != sorted[i] {
                end = i;
                break;
            }
        }
        if start == end {
            0
        } else {
            (end - start + 1) as i32
        }
    }
}