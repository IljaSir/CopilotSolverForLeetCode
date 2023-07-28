impl Solution {
    pub fn xor_queries(arr: Vec<i32>, queries: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut ans = vec![];
        for i in 0..queries.len() {
            let mut tmp = arr[queries[i][0] as usize];
            for j in queries[i][0] + 1..=queries[i][1] {
                tmp ^= arr[j as usize];
            }
            ans.push(tmp);
        }
        ans
    }
}