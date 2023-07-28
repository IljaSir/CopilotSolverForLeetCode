impl Solution {
    pub fn find_unsorted_subarray(nums: Vec<i32>) -> i32 {
        

        if nums.len() == 1 {
            return 0;
        }
        let mut min = std::i32::MAX;
        let mut max = std::i32::MIN;
        let mut start = 0;
        let mut end = 0;
        for i in 0..nums.len() {
            if nums[i] < max {
                end = i;
            } else {
                max = nums[i];
            }
            if nums[nums.len() - i - 1] > min {
                start = nums.len() - i - 1;
            } else {
                min = nums[nums.len() - i - 1];
            }
        }
        if end == 0 {
            0
        } else {
            (end - start + 1) as i32
        }
    }
}