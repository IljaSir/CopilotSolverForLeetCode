impl Solution {
    pub fn xor_queries(arr: Vec<i32>, queries: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut res = vec![];
        for q in queries {
            let mut r = 0;
            for i in q[0] as usize .. q[1] as usize + 1 {
                r ^= arr[i];
            }
            res.push(r);
        }
        res
    }
}