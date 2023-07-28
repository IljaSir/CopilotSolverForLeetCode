impl Solution {
    pub fn relative_sort_array(arr1: Vec<i32>, arr2: Vec<i32>) -> Vec<i32> {
        
        let mut arr1 = arr1;
        let mut arr2 = arr2;
        arr1.sort();
        arr2.sort();
        let mut result = Vec::new();
        let mut i = 0;
        let mut j = 0;
        while j < arr2.len() {
            while i < arr1.len() && arr1[i] < arr2[j] {
                result.push(arr1[i]);
                i += 1;
            }
            while i < arr1.len() && arr1[i] == arr2[j] {
                result.push(arr1[i]);
                i += 1;
            }
            j += 1;
        }
        while i < arr1.len() {
            result.push(arr1[i]);
            i += 1;
        }
        result
    }
}