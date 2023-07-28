impl Solution {
    pub fn count_triplets(arr: Vec<i32>) -> i32 {
        
        let mut count = 0;
        let mut xor = vec![0; arr.len() + 1];
        for i in 0..arr.len() {
            xor[i + 1] = xor[i] ^ arr[i];
        }
        for i in 0..arr.len() {
            for k in i + 1..arr.len() {
                if xor[i] == xor[k + 1] {
                    count += k - i;
                }
            }
        }
        count as i32
    }
}