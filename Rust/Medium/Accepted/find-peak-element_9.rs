impl Solution {
    pub fn find_peak_element(nums: Vec<i32>) -> i32 {
        

        let mut l = 0;
        let mut r = nums.len() - 1;
        let mut mid = (l + r) / 2;
        while l < r {
            if nums[mid] < nums[mid + 1] {
                l = mid + 1;
            } else {
                r = mid;
            }
            mid = (l + r) / 2;
        }
        mid as i32
    }
}