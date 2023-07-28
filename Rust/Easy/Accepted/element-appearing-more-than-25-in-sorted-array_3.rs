impl Solution {
    pub fn find_special_integer(arr: Vec<i32>) -> i32 {
        
        let l = arr.len();
        let mut i = 0;
        while i < l {
            let mut j = i;
            while j < l && arr[j] == arr[i] {
                j += 1;
            }
            if (j - i) * 4 > l {
                return arr[i];
            }
            i = j;
        }
        -1
    }
}