impl Solution {
    pub fn find_special_integer(arr: Vec<i32>) -> i32 {
        
        let len = arr.len();
        for i in 0..len {
            if i + len / 4 < len && arr[i] == arr[i + len / 4] {
                return arr[i];
            }
        }
        -1
    }
}