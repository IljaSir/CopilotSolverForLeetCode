impl Solution {
    pub fn find_kth_positive(arr: Vec<i32>, k: i32) -> i32 {
        
        let mut i = 0;
        let mut j = 0;
        let mut k = k;
        while i < arr.len() {
            if arr[i] == j + 1 {
                i += 1;
            } else {
                k -= 1;
            }
            j += 1;
            if k == 0 {
                return j;
            }
        }
        j + k
    }
}