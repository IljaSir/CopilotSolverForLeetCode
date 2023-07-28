impl Solution {
    pub fn smallest_distance_pair(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut nums = nums;
        nums.sort_unstable();
        let n = nums.len();
        let k = k as usize;
        let mut left = 0;
        let mut right = nums[n - 1] - nums[0];
        while left < right {
            let mid = left + (right - left) / 2;
            let mut count = 0;
            let mut start = 0;
            for end in 0..n {
                while nums[end] - nums[start] > mid {
                    start += 1;
                }
                count += end - start;
            }
            if count >= k {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        left as i32
    }
}