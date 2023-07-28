impl Solution {
    pub fn find_peak_element(nums: Vec<i32>) -> i32 {
        

        if nums.len() == 1 {
            return 0;
        }
        let mut l = 0;
        let mut r = nums.len() - 1;
        while l < r {
            let m = l + (r - l) / 2;
            if nums[m] > nums[m + 1] {
                r = m;
            } else {
                l = m + 1;
            }
        }
        l as i32
    }
}