impl Solution {
    pub fn count_triplets(arr: Vec<i32>) -> i32 {
        
        let n = arr.len();
        let mut pre = vec![0; n + 1];
        for i in 0..n {
            pre[i + 1] = pre[i] ^ arr[i];
        }
        let mut ans = 0;
        for i in 0..n {
            for k in i + 1..n {
                if pre[i] == pre[k + 1] {
                    ans += k - i;
                }
            }
        }
        ans as i32
    }
}