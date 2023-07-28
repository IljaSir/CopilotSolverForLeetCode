impl Solution {
    pub fn split_array(nums: Vec<i32>, k: i32) -> i32 {
        
        let (mut left, mut right) = (0, 0);
        for n in nums.iter() {
            left = left.max(*n);
            right += n;
        }

        while left < right {
            let mid = left + (right - left) / 2;
            let mut count = 1;
            let mut sum = 0;
            for n in nums.iter() {
                if sum + n > mid {
                    count += 1;
                    sum = *n;
                } else {
                    sum += n;
                }
            }
            if count > k {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        left
    }
}