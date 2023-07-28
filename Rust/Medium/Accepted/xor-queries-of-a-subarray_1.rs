impl Solution {
    pub fn xor_queries(arr: Vec<i32>, queries: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut xor: Vec<i32> = vec![0; arr.len() + 1];
        for i in 0..arr.len() {
            xor[i + 1] = xor[i] ^ arr[i];
        }
        let mut res: Vec<i32> = vec![];
        for q in queries {
            res.push(xor[q[0] as usize] ^ xor[q[1] as usize + 1]);
        }
        res
    }
}