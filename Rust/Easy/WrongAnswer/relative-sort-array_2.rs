impl Solution {
    pub fn relative_sort_array(arr1: Vec<i32>, arr2: Vec<i32>) -> Vec<i32> {
        
        let mut arr1 = arr1;
        arr1.sort();
        let mut arr2 = arr2;
        arr2.sort();
        let mut pos = 0;
        for i in 0..arr2.len() {
            let mut j = pos;
            while j < arr1.len() {
                if arr1[j] == arr2[i] {
                    arr1.swap(j, pos);
                    pos += 1;
                }
                j += 1;
            }
        }
        arr1
    }
}