impl Solution {
    pub fn find_kth_positive(arr: Vec<i32>, k: i32) -> i32 {
        
        let mut k = k;
        let mut i = 1;
        let mut j = 0;
        while k > 0 {
            if j < arr.len() && arr[j] == i {
                j += 1;
            } else {
                k -= 1;
            }
            i += 1;
        }
        i - 1
    }
}