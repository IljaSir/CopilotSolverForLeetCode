impl Solution {
    pub fn find_kth_positive(arr: Vec<i32>, k: i32) -> i32 {
        
        let mut i = 0;
        let mut k = k;
        let mut n = 1;
        while k > 0 {
            if i < arr.len() && arr[i] == n {
                i += 1;
            } else {
                k -= 1;
            }
            n += 1;
        }
        n - 1
    }
}