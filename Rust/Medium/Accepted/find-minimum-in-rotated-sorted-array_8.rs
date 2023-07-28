impl Solution {
    pub fn find_min(nums: Vec<i32>) -> i32 {
        

        let mut start = 0;
        let mut end = nums.len() - 1;
        while start < end {
            let mid = start + (end - start) / 2;
            if nums[mid] < nums[end] {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        nums[start]
    }
}