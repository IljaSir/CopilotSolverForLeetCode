impl Solution {
    pub fn get_max_len(nums: Vec<i32>) -> i32 {
        
        let mut pos = vec![0; nums.len()];
        let mut neg = vec![0; nums.len()];
        let mut res = 0;
        for (i, &n) in nums.iter().enumerate() {
            if n > 0 {
                pos[i] = 1;
                neg[i] = neg.get(i-1).unwrap_or(&0) + 1;
            } else if n < 0 {
                pos[i] = neg.get(i-1).unwrap_or(&0) + 1;
                neg[i] = 1;
            }
            res = res.max(pos[i]);
        }
        res
    }
}