impl Solution {
    pub fn check_if_exist(arr: Vec<i32>) -> bool {
        
        let mut arr = arr;
        arr.sort();
        for i in 0..arr.len() {
            if arr[i] == 0 {
                if arr[i + 1] == 0 {
                    return true;
                }
            } else if arr[i] < 0 {
                let index = arr.binary_search(&(arr[i] / 2)).unwrap_or_else(|x| x);
                if index < arr.len() && arr[index] == arr[i] / 2 {
                    return true;
                }
            } else {
                let index = arr.binary_search(&(arr[i] * 2)).unwrap_or_else(|x| x);
                if index < arr.len() && arr[index] == arr[i] * 2 {
                    return true;
                }
            }
        }
        false
    }
}