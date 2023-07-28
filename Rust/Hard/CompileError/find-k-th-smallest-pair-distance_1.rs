impl Solution {
    pub fn smallest_distance_pair(nums: Vec<i32>, k: i32) -> i32 {
        
        let n = nums.len();
        let mut nums = nums;
        nums.sort();
        let mut lo = 0;
        let mut hi = nums[n-1] - nums[0];
        while lo < hi {
            let mi = lo + (hi - lo) / 2;
            let mut count = 0;
            let mut left = 0;
            for right in 0..n {
                while nums[right] - nums[left] > mi {
                    left += 1;
                }
                count += right - left;
            }
            if count >= k {
                hi = mi;
            } else {
                lo = mi + 1;
            }
        }
        lo
    }
}