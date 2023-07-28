impl Solution {
    pub fn find_kth_positive(arr: Vec<i32>, k: i32) -> i32 {
        
        let mut i = 1;
        let mut k = k;
        for x in arr {
            while i < x {
                k -= 1;
                if k == 0 {
                    return i;
                }
                i += 1;
            }
            i += 1;
        }
        while k > 0 {
            k -= 1;
            i += 1;
        }
        i - 1
    }
}