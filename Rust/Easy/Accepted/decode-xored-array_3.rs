impl Solution {
    pub fn decode(encoded: Vec<i32>, first: i32) -> Vec<i32> {
        
        let mut arr = vec![first];
        for i in encoded {
            arr.push(arr.last().unwrap() ^ i);
        }
        arr
    }
}