impl Solution {
    pub fn can_reorder_doubled(arr: Vec<i32>) -> bool {
        
        let mut arr = arr;
        arr.sort();
        let mut count = 0;
        let mut i = 0;
        let mut j = 1;
        while i < arr.len() && j < arr.len() {
            if arr[i] < 0 && arr[j] < 0 {
                if arr[j] == arr[i] / 2 {
                    count += 1;
                    i += 2;
                    j += 2;
                } else if arr[j] > arr[i] / 2 {
                    i += 1;
                    j += 1;
                } else {
                    j += 1;
                }
            } else if arr[i] > 0 && arr[j] > 0 {
                if arr[j] == arr[i] * 2 {
                    count += 1;
                    i += 2;
                    j += 2;
                } else if arr[j] > arr[i] * 2 {
                    i += 1;
                    j += 1;
                } else {
                    j += 1;
                }
            } else {
                j += 1;
            }
        }
        count == arr.len() / 2
    }
}