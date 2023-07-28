impl Solution {
    pub fn valid_subarray_size(nums: Vec<i32>, threshold: i32) -> i32 {
        
        let mut l = 0;
        let mut r = nums.len();
        let mut s = nums.iter().sum::<i32>();
        while l < r {
            let mid = (l + r) / 2;
            if s > threshold * mid as i32 {
                l = mid + 1;
            } else {
                r = mid;
            }
            s -= nums[mid];
        }
        if l == nums.len() {
            -1
        } else {
            l as i32
        }
    }
}