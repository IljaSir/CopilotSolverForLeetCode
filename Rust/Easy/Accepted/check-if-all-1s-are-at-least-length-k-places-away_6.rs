impl Solution {
    pub fn k_length_apart(nums: Vec<i32>, k: i32) -> bool {
        
        let mut last_index = 0;
        let mut first = true;
        for (i, &v) in nums.iter().enumerate() {
            if v == 1 {
                if first {
                    first = false;
                } else {
                    if i - last_index <= k as usize {
                        return false;
                    }
                }
                last_index = i;
            }
        }
        true
    }
}