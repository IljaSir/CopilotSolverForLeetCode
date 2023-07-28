impl Solution {
    pub fn search(nums: Vec<i32>, target: i32) -> i32 {
        
        let mut start = 0;
        let mut end = nums.len() - 1;
        while start <= end {
            let mid = start + (end - start) / 2;
            if nums[mid] == target {
                return mid as i32;
            } else if nums[mid] < target {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        -1
    }
}