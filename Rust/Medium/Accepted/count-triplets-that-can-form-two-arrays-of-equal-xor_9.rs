impl Solution {
    pub fn count_triplets(arr: Vec<i32>) -> i32 {
        
        let mut ans = 0;
        let mut v = vec![0];
        for i in 0..arr.len() {
            v.push(v[i] ^ arr[i]);
        }
        for i in 0..arr.len() {
            for k in i + 1..arr.len() {
                if v[i] == v[k + 1] {
                    ans += k - i;
                }
            }
        }
        ans as i32
    }
}