impl Solution {
    pub fn find_kth_positive(arr: Vec<i32>, k: i32) -> i32 {
        
        let mut missing = 0;
        let mut j = 1;
        for i in 0..arr.len() {
            while j < arr[i] {
                missing += 1;
                if missing == k {
                    return j;
                }
                j += 1;
            }
            j += 1;
        }
        while missing < k {
            missing += 1;
            j += 1;
        }
        j - 1
    }
}