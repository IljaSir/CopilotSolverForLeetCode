impl Solution {
    pub fn count_triplets(arr: Vec<i32>) -> i32 {
        
        let mut res = 0;
        let mut xor = 0;
        let mut count = vec![vec![0; arr.len()]; arr.len()];
        for i in 0..arr.len() {
            xor ^= arr[i];
            for j in i + 1..arr.len() {
                if xor == (xor ^ arr[j]) {
                    res += j - i;
                }
                count[i][j] = res;
            }
            res = 0;
        }
        res = 0;
        for i in 0..arr.len() {
            for j in i + 1..arr.len() {
                for k in j..arr.len() {
                    if arr[i] == arr[k + 1] {
                        res += 1;
                    }
                }
            }
        }
        res
    }
}