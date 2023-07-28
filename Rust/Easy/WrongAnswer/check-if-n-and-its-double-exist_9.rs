impl Solution {
    pub fn check_if_exist(arr: Vec<i32>) -> bool {
        
        let mut arr = arr;
        arr.sort_unstable();
        let len = arr.len();
        for i in 0..len {
            for j in i..len {
                if i == j {
                    continue;
                }
                if arr[i] == arr[j] * 2 {
                    return true;
                }
            }
        }
        false
    }
}