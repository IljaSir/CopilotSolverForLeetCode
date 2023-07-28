impl Solution {
    pub fn search(nums: Vec<i32>, target: i32) -> bool {
        

        let mut l = 0;
        let mut r = nums.len() - 1;
        while l <= r {
            let m = l + (r - l) / 2;
            if target == nums[m] {
                return true;
            }
            if nums[l] == nums[m] {
                l += 1;
            } else if nums[l] < nums[m] {
                if target >= nums[l] && target < nums[m] {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                if target > nums[m] && target <= nums[r] {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        false
    }
}