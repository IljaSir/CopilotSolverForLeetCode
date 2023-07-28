impl Solution {
    pub fn get_max_len(nums: Vec<i32>) -> i32 {
        
        let mut max_len = 0;
        let mut first_neg = -1;
        let mut last_zero = -1;
        let mut last_neg = -1;
        for (i, &num) in nums.iter().enumerate() {
            if num == 0 {
                max_len = max_len.max(i as i32 - last_zero - 1);
                first_neg = -1;
                last_neg = -1;
                last_zero = i as i32;
            } else if num < 0 {
                if first_neg == -1 {
                    first_neg = i as i32;
                }
                last_neg = i as i32;
            }
            if first_neg != -1 {
                max_len = max_len.max(i as i32 - first_neg);
            }
            if last_neg != -1 {
                max_len = max_len.max(i as i32 - last_neg);
            }
        }
        max_len = max_len.max(nums.len() as i32 - last_zero - 1);
        max_len
    }
}