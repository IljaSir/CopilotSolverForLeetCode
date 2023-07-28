impl Solution {
    pub fn decode(encoded: Vec<i32>, first: i32) -> Vec<i32> {
        
        let mut decoded = vec![first];
        for i in 0..encoded.len() {
            let next = decoded[i] ^ encoded[i];
            decoded.push(next);
        }
        return decoded;
    }
}