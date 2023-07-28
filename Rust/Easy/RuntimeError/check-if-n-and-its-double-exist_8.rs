impl Solution {
    pub fn check_if_exist(arr: Vec<i32>) -> bool {
        
        let mut arr = arr;
        arr.sort();
        for i in 0..arr.len() {
            let n = arr[i];
            let mut l = 0;
            let mut r = arr.len() - 1;
            while l <= r {
                let m = (l + r) / 2;
                if arr[m] == n * 2 && m != i {
                    return true;
                } else if arr[m] < n * 2 {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        false
    }
}