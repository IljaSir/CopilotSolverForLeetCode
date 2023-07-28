impl Solution {
    pub fn min_operations(nums: Vec<i32>, x: i32) -> i32 {
        
        let sum = nums.iter().sum::<i32>();
        let n = nums.len();
        let target = sum - x;
        if target < 0 {
            return -1;
        }
        if target == 0 {
            return n as i32;
        }
        let mut cur = 0;
        let mut left = 0;
        let mut res = -1;
        for right in 0..n {
            cur += nums[right];
            while cur > target {
                cur -= nums[left];
                left += 1;
            }
            if cur == target {
                res = res.max(right - left + 1);
            }
        }
        if res < 0 {
            return -1;
        }
        (n - res) as i32
    }
}