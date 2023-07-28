impl Solution {
    pub fn min_sub_array_len(target: i32, nums: Vec<i32>) -> i32 {
        

        let n = nums.len();
        let mut ans = n + 1;
        let mut start = 0;
        let mut sum = 0;
        for i in 0..n {
            sum += nums[i];
            while sum >= target {
                ans = ans.min(i - start + 1);
                sum -= nums[start];
                start += 1;
            }
        }
        if ans == n + 1 {
            0
        } else {
            ans as i32
        }
    }
}