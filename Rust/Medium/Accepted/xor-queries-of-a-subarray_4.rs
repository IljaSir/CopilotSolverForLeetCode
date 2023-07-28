impl Solution {
    pub fn xor_queries(arr: Vec<i32>, queries: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut res = Vec::new();
        let mut xor = Vec::new();
        xor.push(0);
        for i in 0..arr.len() {
            xor.push(xor[i] ^ arr[i]);
        }
        for q in queries {
            res.push(xor[q[0] as usize] ^ xor[(q[1] + 1) as usize]);
        }
        res
    }
}