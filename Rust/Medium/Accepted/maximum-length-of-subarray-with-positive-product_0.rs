impl Solution {
    pub fn get_max_len(nums: Vec<i32>) -> i32 {
        
        let mut ans = 0;
        let mut pos = 0;
        let mut neg = 0;
        for n in nums {
            if n == 0 {
                pos = 0;
                neg = 0;
            } else if n > 0 {
                pos += 1;
                if neg > 0 {
                    neg += 1;
                }
            } else {
                let tmp = pos;
                if neg > 0 {
                    pos = neg + 1;
                } else {
                    pos = 0;
                }
                neg = tmp + 1;
            }
            ans = ans.max(pos);
        }
        ans
    }
}