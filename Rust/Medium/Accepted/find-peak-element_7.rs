impl Solution {
    pub fn find_peak_element(nums: Vec<i32>) -> i32 {
        

        let mut i = 0;
        let mut j = nums.len() - 1;
        while i < j {
            let mid = (i + j) / 2;
            if nums[mid] > nums[mid + 1] {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        i as i32
    }
}