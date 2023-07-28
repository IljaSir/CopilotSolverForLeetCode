impl Solution {
    pub fn find_special_integer(arr: Vec<i32>) -> i32 {
        
        let n = arr.len();
        let mut count = 0;
        let mut last = arr[0];
        for i in 0..n {
            if arr[i] == last {
                count += 1;
            } else {
                last = arr[i];
                count = 1;
            }
            if count > n / 4 {
                return arr[i];
            }
        }
        0
    }
}