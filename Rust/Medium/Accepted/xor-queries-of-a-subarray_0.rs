impl Solution {
    pub fn xor_queries(arr: Vec<i32>, queries: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut prefix: Vec<i32> = vec![0; arr.len() + 1];
        for i in 0..arr.len() {
            prefix[i + 1] = prefix[i] ^ arr[i];
        }
        let mut ans = Vec::new();
        for query in queries {
            ans.push(prefix[query[0] as usize] ^ prefix[query[1] as usize + 1]);
        }
        ans
    }
}