impl Solution {
    pub fn longest_subarray(nums: Vec<i32>) -> i32 {
        
        let mut ans = 0;
        let mut l = 0;
        let mut r = 0;
        let mut k = 1;
        while r < nums.len() {
            if nums[r] == 0 {
                k -= 1;
            }
            while k < 0 {
                if nums[l] == 0 {
                    k += 1;
                }
                l += 1;
            }
            ans = ans.max(r - l);
            r += 1;
        }
        ans as i32
    }
}