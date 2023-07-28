impl Solution {
    pub fn k_length_apart(nums: Vec<i32>, k: i32) -> bool {
        
        let mut last_pos = 0;
        let mut first = true;
        for (i, &n) in nums.iter().enumerate() {
            if n == 1 {
                if first {
                    first = false;
                } else {
                    if i - last_pos - 1 < k as usize {
                        return false;
                    }
                }
                last_pos = i;
            }
        }
        true
    }
}