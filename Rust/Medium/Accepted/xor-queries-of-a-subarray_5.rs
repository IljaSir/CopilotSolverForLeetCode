impl Solution {
    pub fn xor_queries(arr: Vec<i32>, queries: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut res = Vec::new();
        for i in 0..queries.len() {
            let mut tmp = 0;
            for j in queries[i][0] as usize..queries[i][1] as usize + 1 {
                tmp ^= arr[j];
            }
            res.push(tmp);
        }
        res
    }
}