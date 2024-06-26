impl Solution {
    pub fn find_min(nums: Vec<i32>) -> i32 {
        
        let n = nums.len();
        let mut l = 0;
        let mut r = n - 1;
        while l < r {
            let mid = l + (r - l) / 2;
            if nums[mid] < nums[r] {
                r = mid;
            } else if nums[mid] > nums[r] {
                l = mid + 1;
            } else {
                r -= 1;
            }
        }
        nums[l]
    }
}