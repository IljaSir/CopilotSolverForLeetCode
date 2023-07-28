impl Solution {
    pub fn search(nums: Vec<i32>, target: i32) -> bool {
        

        let n = nums.len();
        let mut l = 0;
        let mut r = n - 1;
        while l <= r {
            let mid = l + (r - l) / 2;
            if nums[mid] == target {
                return true;
            }
            if nums[mid] == nums[l] && nums[mid] == nums[r] {
                l += 1;
                r -= 1;
            } else if nums[mid] >= nums[l] {
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