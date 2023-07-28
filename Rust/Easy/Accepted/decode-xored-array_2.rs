impl Solution {
    pub fn decode(encoded: Vec<i32>, first: i32) -> Vec<i32> {
        
        let mut ans = vec![first];
        for i in 0..encoded.len() {
            ans.push(encoded[i] ^ ans[i]);
        }
        ans
    }
}