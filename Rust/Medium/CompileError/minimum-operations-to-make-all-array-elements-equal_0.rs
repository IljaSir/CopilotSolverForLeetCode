impl Solution {
    pub fn min_operations(nums: Vec<i32>, queries: Vec<i32>) -> Vec<i64> {
        
        let mut res = vec![];
        for q in queries {
            let mut c = 0;
            for n in nums.iter() {
                if n < &q {
                    c += q - n;
                }
            }
            res.push(c);
        }
        res
    }
}