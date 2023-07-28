impl Solution {
    pub fn k_length_apart(nums: Vec<i32>, k: i32) -> bool {
        
        let mut last = -1;
        let mut i = 0;
        for (i, n) in nums.iter().enumerate() {
            if *n == 1 {
                if last != -1 && i as i32 - last - 1 < k {
                    return false;
                }
                last = i as i32;
            }
        }
        true
    }
}