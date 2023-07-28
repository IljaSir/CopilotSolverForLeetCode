impl Solution {
    pub fn valid_subarray_size(nums: Vec<i32>, threshold: i32) -> i32 {
        
        // 1. find the max value in nums
        let max = nums.iter().fold(0, |acc, &x| acc.max(x));
        // 2. binary search for the subarray size
        let mut l = 1;
        let mut r = nums.len();
        while l <= r {
            let mid = (l + r) / 2;
            let sum = nums.windows(mid).map(|w| w.iter().sum::<i32>()).max().unwrap();
            if sum > threshold {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if l > nums.len() { -1 } else { l as i32 }
    }
}