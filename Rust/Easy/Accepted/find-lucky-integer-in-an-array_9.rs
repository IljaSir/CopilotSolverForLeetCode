impl Solution {
    pub fn find_lucky(arr: Vec<i32>) -> i32 {
        
        let mut arr = arr;
        arr.sort();
        let mut i = 0;
        let mut max = -1;
        while i < arr.len() {
            let mut j = i;
            while j < arr.len() && arr[i] == arr[j] {
                j += 1;
            }
            if arr[i] == (j - i) as i32 {
                max = arr[i];
            }
            i = j;
        }
        max
    }
}