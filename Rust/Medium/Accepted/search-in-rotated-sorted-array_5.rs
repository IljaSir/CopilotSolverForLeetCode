impl Solution {
    pub fn search(nums: Vec<i32>, target: i32) -> i32 {
        

        let mut lo = 0;
        let mut hi = nums.len() - 1;
        while lo <= hi {
            let mid = lo + (hi - lo) / 2;
            if nums[mid] == target {
                return mid as i32;
            }
            if nums[lo] <= nums[mid] {
                if target >= nums[lo] && target < nums[mid] {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if target > nums[mid] && target <= nums[hi] {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        -1
    }
}