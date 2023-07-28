impl Solution {
    pub fn find_min(nums: Vec<i32>) -> i32 {
        

        let n = nums.len();
        let mut left = 0;
        let mut right = n - 1;
        while left < right {
            let mid = left + (right - left) / 2;
            if nums[mid] < nums[right] {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        nums[left]
    }
}