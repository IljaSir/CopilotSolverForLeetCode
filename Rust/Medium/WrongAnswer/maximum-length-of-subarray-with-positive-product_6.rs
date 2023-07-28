impl Solution {
    pub fn get_max_len(nums: Vec<i32>) -> i32 {
        
        let mut res = 0;
        let mut l = 0;
        let mut r = 0;
        let mut neg = 0;
        for i in 0..nums.len() {
            if nums[i] < 0 {
                neg += 1;
            }
            if nums[i] == 0 {
                l = 0;
                r = 0;
                neg = 0;
            } else {
                r += 1;
                if neg % 2 == 0 {
                    res = res.max(r);
                } else {
                    res = res.max(r - l);
                }
                if neg % 2 == 1 {
                    l = r;
                }
            }
        }
        res
    }
}