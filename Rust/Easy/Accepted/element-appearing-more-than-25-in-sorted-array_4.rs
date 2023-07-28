impl Solution {
    pub fn find_special_integer(arr: Vec<i32>) -> i32 {
        
        let n = arr.len();
        let mut i = 0;
        let mut j = 0;
        while i < n {
            while j < n && arr[j] == arr[i] {
                j += 1;
            }
            if j - i > n / 4 {
                return arr[i];
            }
            i = j;
        }
        0
    }
}