impl Solution {
    pub fn get_max_len(nums: Vec<i32>) -> i32 {
        
        let (mut pos, mut neg) = (0, 0);
        let mut ans = 0;
        for &x in &nums {
            if x > 0 {
                pos += 1;
                if neg > 0 {
                    neg += 1;
                }
            } else if x < 0 {
                let tmp = pos;
                pos = if neg > 0 { neg + 1 } else { 0 };
                neg = tmp + 1;
            } else {
                pos = 0;
                neg = 0;
            }
            ans = ans.max(pos);
        }
        ans
    }
}