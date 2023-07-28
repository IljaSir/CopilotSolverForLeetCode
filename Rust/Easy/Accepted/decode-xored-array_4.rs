impl Solution {
    pub fn decode(encoded: Vec<i32>, first: i32) -> Vec<i32> {
        
        let mut res = vec![first];
        for i in encoded {
            res.push(i ^ res.last().unwrap());
        }
        res
    }
}