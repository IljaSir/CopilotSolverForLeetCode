impl Solution {
    pub fn min_operations(nums: Vec<i32>, queries: Vec<i32>) -> Vec<i64> {
        
        let mut res = Vec::new();
        for q in queries {
            let mut cnt = 0;
            for n in nums.iter() {
                if q > *n {
                    cnt += q - n;
                }
            }
            res.push(cnt as i64);
        }
        return res;
    }
}