impl Solution {
    pub fn split_array(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut left = 0;
        let mut right = 0;
        for n in nums.iter() {
            left = left.max(*n);
            right += n;
        }
        while left < right {
            let mid = left + (right - left) / 2;
            let mut sum = 0;
            let mut cnt = 1;
            for n in nums.iter() {
                sum += n;
                if sum > mid {
                    cnt += 1;
                    sum = *n;
                }
            }
            if cnt > k {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        left
    }
}