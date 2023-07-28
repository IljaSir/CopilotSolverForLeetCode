impl Solution {
    pub fn max_turbulence_size(arr: Vec<i32>) -> i32 {
        
        let mut max = 1;
        let mut i = 0;
        let mut j = 1;
        while j < arr.len() {
            if arr[j] == arr[j - 1] {
                i = j;
            } else if j == arr.len() - 1 || (arr[j] > arr[j - 1] && arr[j] > arr[j + 1]) || (arr[j] < arr[j - 1] && arr[j] < arr[j + 1]) {
                max = max.max(j - i + 1);
                i = j;
            }
            j += 1;
        }
        max
    }
}