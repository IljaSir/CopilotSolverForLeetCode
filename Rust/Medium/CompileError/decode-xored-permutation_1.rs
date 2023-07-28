impl Solution {
    pub fn decode(encoded: Vec<i32>) -> Vec<i32> {
        
        let n = encoded.len() + 1;
        let mut total = 0;
        for i in 1..=n {
            total ^= i;
        }
        let mut odd = 0;
        for i in (1..n-1).step_by(2) {
            odd ^= encoded[i];
        }
        let mut perm = vec![0; n];
        perm[0] = total ^ odd;
        for i in 1..n {
            perm[i] = perm[i-1] ^ encoded[i-1];
        }
        perm
    }
}