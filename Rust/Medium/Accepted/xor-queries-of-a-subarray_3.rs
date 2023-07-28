impl Solution {
    pub fn xor_queries(arr: Vec<i32>, queries: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut xors = vec![0; arr.len() + 1];
        for (i, &v) in arr.iter().enumerate() {
            xors[i + 1] = xors[i] ^ v;
        }
        queries.iter().map(|q| xors[q[0] as usize] ^ xors[q[1] as usize + 1]).collect()
    }
}