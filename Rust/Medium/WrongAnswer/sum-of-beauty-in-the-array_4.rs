impl Solution {
    pub fn sum_of_beauties(nums: Vec<i32>) -> i32 {
        
        let n = nums.len();
        let mut l = vec![0; n];
        let mut r = vec![0; n];
        let mut ans = 0;
        for i in 1..n-1 {
            l[i] = l[i-1].max(nums[i-1]);
            r[n-i-1] = r[n-i].max(nums[n-i]);
        }
        for i in 1..n-1 {
            if nums[i] > l[i] && nums[i] < r[i] {
                ans += 2;
            } else if nums[i-1] < nums[i] && nums[i] < nums[i+1] {
                ans += 1;
            }
        }
        ans
    }
}