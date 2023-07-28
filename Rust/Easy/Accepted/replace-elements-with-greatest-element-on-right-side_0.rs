impl Solution {
    pub fn replace_elements(arr: Vec<i32>) -> Vec<i32> {
        
        let mut arr = arr;
        let mut max = -1;
        for i in (0..arr.len()).rev() {
            let tmp = arr[i];
            arr[i] = max;
            max = max.max(tmp);
        }
        arr
    }
}