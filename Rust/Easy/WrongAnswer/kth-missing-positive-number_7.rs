impl Solution {
    pub fn find_kth_positive(arr: Vec<i32>, k: i32) -> i32 {
        
        let mut missing = 0;
        let mut j = 0;
        let mut i = 1;
        while j < arr.len() && missing < k {
            if arr[j] == i {
                j += 1;
            } else {
                missing += 1;
            }
            i += 1;
        }
        if missing < k {
            missing += 1;
            i += 1;
        }
        i - 1
    }
}