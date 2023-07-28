impl Solution {
    pub fn plus_one(digits: Vec<i32>) -> Vec<i32> {
        
        let mut res = digits;
        let mut i = res.len() - 1;
        while i >= 0 {
            if res[i] < 9 {
                res[i] += 1;
                return res;
            } else {
                res[i] = 0;
            }
            i -= 1;
        }
        res.insert(0, 1);
        res
    }
}