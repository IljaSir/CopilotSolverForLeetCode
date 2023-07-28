impl Solution {
    pub fn find_special_integer(arr: Vec<i32>) -> i32 {
        
        let mut i = 0;
        let mut j = 0;
        while j < arr.len() {
            if arr[i] != arr[j] {
                if j - i > arr.len() / 4 {
                    return arr[i];
                }
                i = j;
            }
            j += 1;
        }
        arr[i]
    }
}