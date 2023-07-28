impl Solution {
    pub fn find_unsorted_subarray(nums: Vec<i32>) -> i32 {
        

        let mut nums = nums;
        let mut sorted = nums.clone();
        sorted.sort();
        let mut start = 0;
        let mut end = nums.len();
        while start < nums.len() && nums[start] == sorted[start] {
            start += 1;
        }
        while end > 0 && nums[end - 1] == sorted[end - 1] {
            end -= 1;
        }
        if start >= end {
            return 0;
        }
        (end - start) as i32
    }
}