impl Solution {
    pub fn search(nums: Vec<i32>, target: i32) -> bool {
        

        let mut l = 0;
        let mut r = nums.len() - 1;
        while l <= r {
            let mid = (l + r) / 2;
            if nums[mid] == target {
                return true;
            }
            if nums[l] == nums[mid] {
                l += 1;
                continue;
            }
            if nums[l] < nums[mid] {
                if nums[l] <= target && target < nums[mid] {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if nums[mid] < target && target <= nums[r] {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        false
    }
}