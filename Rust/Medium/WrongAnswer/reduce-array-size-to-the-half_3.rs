impl Solution {
    pub fn min_set_size(arr: Vec<i32>) -> i32 {
        
        let mut arr = arr;
        arr.sort();
        let mut count = 0;
        let mut result = 0;
        let mut i = arr.len() - 1;
        while count < arr.len() / 2 {
            count += 1;
            if i == 0 || arr[i] != arr[i - 1] {
                result += 1;
            } else {
                while i > 0 && arr[i] == arr[i - 1] {
                    i -= 1;
                    count += 1;
                }
            }
            i -= 1;
        }
        result
    }
}