impl Solution {
    pub fn longest_ones(nums: Vec<i32>, k: i32) -> i32 {
        
        let (mut l, mut r, mut max, mut k) = (0, 0, 0, k);
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
            max = max.max(r - l + 1);
            r += 1;
        }
        max as i32
    }
}