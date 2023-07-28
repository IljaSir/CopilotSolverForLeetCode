impl Solution {
    pub fn number_of_subarrays(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut cnt = 0;
        let mut k = k;
        let mut i = 0;
        let mut j = 0;
        while j < nums.len() {
            k -= nums[j] & 1;
            while k < 0 {
                k += nums[i] & 1;
                i += 1;
            }
            let mut t = i;
            while t < nums.len() && nums[t] & 1 == 0 {
                t += 1;
            }
            cnt += t - i + 1;
            j += 1;
        }
        cnt
    }
}