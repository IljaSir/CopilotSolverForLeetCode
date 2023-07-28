impl Solution {
    pub fn search(nums: Vec<i32>, target: i32) -> bool {
        

        let (mut l, mut r) = (0, nums.len() - 1);
        while l <= r {
            let m = (l + r) / 2;
            if nums[m] == target {
                return true;
            }
            if nums[l] == nums[m] {
                l += 1;
            } else if nums[l] < nums[m] {
                if nums[l] <= target && target < nums[m] {
                    r = m;
                } else {
                    l = m + 1;
                }
            } else {
                if nums[m] < target && target <= nums[r] {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
        }
        false
    }
}