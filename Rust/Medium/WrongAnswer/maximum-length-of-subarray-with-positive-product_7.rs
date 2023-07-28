impl Solution {
    pub fn get_max_len(nums: Vec<i32>) -> i32 {
        
        let mut max = 0;
        let mut neg = 0;
        let mut pos = 0;
        for i in 0..nums.len() {
            if nums[i] == 0 {
                neg = 0;
                pos = 0;
            } else if nums[i] < 0 {
                let tmp = pos;
                pos = neg + 1;
                neg = tmp + 1;
            } else {
                pos += 1;
                if neg > 0 {
                    neg += 1;
                }
            }
            if pos > max {
                max = pos;
            }
        }
        max
    }
}