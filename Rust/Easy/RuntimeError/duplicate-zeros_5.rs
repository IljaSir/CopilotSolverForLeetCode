impl Solution {
    pub fn duplicate_zeros(arr: &mut Vec<i32>) {
        
        let mut i = 0;
        let mut j = 0;
        while j < arr.len() {
            if arr[i] == 0 {
                j += 2;
            } else {
                j += 1;
            }
            i += 1;
        }
        if j == arr.len() + 1 {
            arr[i-1] = 0;
            i -= 2;
        } else {
            i -= 1;
        }
        while i >= 0 {
            if arr[i] == 0 {
                arr[i+j] = 0;
                arr[i+j-1] = 0;
                j -= 2;
            } else {
                arr[i+j] = arr[i];
                j -= 1;
            }
            i -= 1;
        }
    }
}