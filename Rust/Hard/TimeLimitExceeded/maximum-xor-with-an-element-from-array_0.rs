impl Solution {
    pub fn maximize_xor(nums: Vec<i32>, queries: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut res = vec![];
        for q in queries {
            let mut max = -1;
            for n in nums.iter() {
                if n <= &q[1] {
                    max = max.max(q[0] ^ n);
                }
            }
            res.push(max);
        }
        res
    }
}