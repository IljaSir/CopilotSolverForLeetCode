impl Solution {
    pub fn can_make_arithmetic_progression(arr: Vec<i32>) -> bool {
        
        let mut arr = arr;
        arr.sort();
        let mut diff = 0;
        for i in 1..arr.len() {
            if i == 1 {
                diff = arr[i] - arr[i - 1];
            } else {
                if arr[i] - arr[i - 1] != diff {
                    return false;
                }
            }
        }
        return true;
    }
}