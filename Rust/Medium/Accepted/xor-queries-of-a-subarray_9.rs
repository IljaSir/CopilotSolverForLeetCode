impl Solution {
    pub fn xor_queries(arr: Vec<i32>, queries: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut ans = vec![];
        for q in &queries {
            let mut num = 0;
            for i in q[0] as usize..=q[1] as usize {
                num ^= arr[i];
            }
            ans.push(num);
        }
        ans
    }
}