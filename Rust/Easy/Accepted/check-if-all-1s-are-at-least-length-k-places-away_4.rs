impl Solution {
    pub fn k_length_apart(nums: Vec<i32>, k: i32) -> bool {
        
        let mut last = -1;
        let mut i = 0;
        for num in nums {
            if num == 1 {
                if last == -1 {
                    last = i;
                } else {
                    if i - last - 1 < k {
                        return false;
                    }
                    last = i;
                }
            }
            i += 1;
        }
        true
    }
}