impl Solution {
    pub fn can_make_arithmetic_progression(arr: Vec<i32>) -> bool {
        
        let mut arr = arr;
        arr.sort();
        let mut i = 1;
        let diff = arr[1] - arr[0];
        while i < arr.len() {
            if arr[i] - arr[i - 1] != diff {
                return false;
            }
            i += 1;
        }
        return true;
    }
}