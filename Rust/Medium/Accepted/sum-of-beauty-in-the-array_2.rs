impl Solution {
    pub fn sum_of_beauties(nums: Vec<i32>) -> i32 {
        
        let n = nums.len();
        let mut left = vec![0; n];
        let mut right = vec![0; n];
        let mut l = nums[0];
        let mut r = nums[n - 1];
        for i in 1..n {
            left[i] = l;
            l = l.max(nums[i]);
            right[n - 1 - i] = r;
            r = r.min(nums[n - 1 - i]);
        }
        let mut sum = 0;
        for i in 1..n - 1 {
            if nums[i] > left[i] && nums[i] < right[i] {
                sum += 2;
            } else if nums[i - 1] < nums[i] && nums[i] < nums[i + 1] {
                sum += 1;
            }
        }
        sum
    }
}