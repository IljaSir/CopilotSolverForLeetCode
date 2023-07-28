impl Solution {
    pub fn maximum_element_after_decrementing_and_rearranging(arr: Vec<i32>) -> i32 {
        
        let mut arr = arr;
        arr.sort_unstable();
        arr[0] = 1;
        for i in 1..arr.len() {
            arr[i] = arr[i-1] + 1;
            if arr[i] > arr[i-1] + 1 {
                arr[i] = arr[i-1] + 1;
            }
        }
        arr[arr.len()-1]
    }
}