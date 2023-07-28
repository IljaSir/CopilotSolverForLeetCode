impl Solution {
    pub fn valid_mountain_array(arr: Vec<i32>) -> bool {
        
        if arr.len() < 3 {
            return false;
        }
        let mut increase = true;
        for i in 1..arr.len() {
            if arr[i] == arr[i-1] {
                return false;
            }
            if arr[i] < arr[i-1] {
                increase = false;
            }
            if arr[i] > arr[i-1] && !increase {
                return false;
            }
        }
        !increase
    }
}