impl Solution {
    pub fn replace_elements(arr: Vec<i32>) -> Vec<i32> {
        
        let mut arr = arr;
        let n = arr.len();
        let mut max = arr[n - 1];
        arr[n - 1] = -1;
        for i in (0..n - 1).rev() {
            let t = arr[i];
            arr[i] = max;
            if t > max {
                max = t;
            }
        }
        arr
    }
}