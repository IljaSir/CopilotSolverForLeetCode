impl Solution {
    pub fn find_unsorted_subarray(nums: Vec<i32>) -> i32 {
        

        let mut nums = nums;
        let mut sorted = nums.clone();
        sorted.sort();
        let mut start = -1;
        let mut end = -1;
        for i in 0..nums.len() {
            if nums[i] != sorted[i] {
                if start == -1 {
                    start = i as i32;
                }
                end = i as i32;
            }
        }
        if start == -1 {
            0
        } else {
            end - start + 1
        }
    }
}