impl Solution {
    pub fn max_product(nums: Vec<i32>) -> i32 {
        

        let mut max = i32::MIN;
        let mut imax = 1;
        let mut imin = 1;
        for i in 0..nums.len() {
            if nums[i] < 0 {
                let tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = std::cmp::max(imax * nums[i], nums[i]);
            imin = std::cmp::min(imin * nums[i], nums[i]);
            max = std::cmp::max(max, imax);
        }
        max
    }
}