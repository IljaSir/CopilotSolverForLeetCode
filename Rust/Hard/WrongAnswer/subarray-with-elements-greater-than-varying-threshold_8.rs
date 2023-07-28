impl Solution {
    pub fn valid_subarray_size(nums: Vec<i32>, threshold: i32) -> i32 {
        
        let mut l = 0;
        let mut r = nums.len();
        let mut ans = -1;
        while l < r {
            let mut sum = 0;
            let mid = (l + r) / 2;
            for i in 0..mid {
                sum += nums[i];
            }
            let mut ok = false;
            for i in mid..nums.len() {
                sum += nums[i];
                if sum > threshold {
                    ok = true;
                    break;
                }
                sum -= nums[i - mid];
            }
            if ok {
                ans = mid as i32;
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        ans
    }
}