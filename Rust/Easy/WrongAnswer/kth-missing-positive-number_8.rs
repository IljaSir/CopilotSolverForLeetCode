impl Solution {
    pub fn find_kth_positive(arr: Vec<i32>, k: i32) -> i32 {
        
        let mut missing = 0;
        let mut last = 0;
        for &n in arr.iter() {
            missing += n - last - 1;
            if missing >= k {
                return last + k;
            }
            last = n;
        }
        last + k - missing
    }
}