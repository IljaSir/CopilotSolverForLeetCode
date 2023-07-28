impl Solution {
    pub fn valid_mountain_array(arr: Vec<i32>) -> bool {
        
        let mut i = 0;
        while i + 1 < arr.len() && arr[i] < arr[i + 1] {
            i += 1;
        }
        if i == 0 || i == arr.len() - 1 {
            return false;
        }
        while i + 1 < arr.len() && arr[i] > arr[i + 1] {
            i += 1;
        }
        i == arr.len() - 1
    }
}