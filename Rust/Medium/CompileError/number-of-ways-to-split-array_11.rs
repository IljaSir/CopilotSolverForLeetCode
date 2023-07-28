impl Solution {
    pub fn ways_to_split_array(nums: Vec<i32>) -> i32 {
        
        let mut sum = 0;
        let mut left = 0;
        let mut right = 0;
        let mut ans = 0;
        let mut n = nums.len();
        let mut arr = nums.clone();
        let mut mod_val = 1000000007;
        for i in 0..n {
            sum += arr[i];
        }
        for i in 0..n - 1 {
            left += arr[i];
            while right < n - 1 && left > sum - left - arr[right + 1] {
                right += 1;
            }
            if right > i {
                ans += right - i;
                ans %= mod_val;
            }
        }
        ans as i32               left += 1;
            }
            while mid + 1 < right && sums[mid + 1] - sums[left] <= sums[right] - sums[mid + 1] {
                mid += 1;
            }
            if sums[left] <= sums[right] - sums[left] && sums[mid] - sums[left] <= sums[right] - sums[mid] {
                result = (result + mid - left + 1) % 1000000007;
            }
        }
        result
    }
}