impl Solution {
    pub fn longest_ones(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut k = k;
        let mut max = 0;
        let mut i = 0;
        for j in 0..nums.len() {
            if nums[j] == 0 {
                k -= 1;
            }
            while k < 0 {
                if nums[i] == 0 {
                    k += 1;
                }
                i += 1;
            }
            max = max.max(j - i + 1);
        }
        max as i32
    }
}