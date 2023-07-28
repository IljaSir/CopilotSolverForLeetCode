impl Solution {
    pub fn find_smallest_integer(nums: Vec<i32>, value: i32) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut mex = 0;
        let mut i = 0;
        while i < nums.len() {
            if nums[i] < mex {
                i += 1;
            } else if nums[i] == mex {
                mex += 1;
                i += 1;
            } else {
                let diff = nums[i] - mex;
                if diff <= value {
                    mex += 1;
                    value -= diff;
                } else {
                    break;
                }
            }
        }
        mex + value / (value.abs() / nums.len() as i32 + 1)
    }
}