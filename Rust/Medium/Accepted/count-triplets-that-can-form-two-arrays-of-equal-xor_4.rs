impl Solution {
    pub fn count_triplets(arr: Vec<i32>) -> i32 {
        
        let mut res = 0;
        for i in 0..arr.len() {
            let mut xor = 0;
            for k in i..arr.len() {
                xor ^= arr[k];
                if xor == 0 && k > i {
                    res += k - i;
                }
            }
        }
        res as i32
    }
}