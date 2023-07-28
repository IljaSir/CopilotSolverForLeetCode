impl Solution {
    pub fn relative_sort_array(arr1: Vec<i32>, arr2: Vec<i32>) -> Vec<i32> {
        
        let mut arr1 = arr1;
        let mut arr2 = arr2;
        let mut result = Vec::new();
        let mut arr2_index = 0;
        let mut arr1_index = 0;
        while arr2_index < arr2.len() {
            while arr1_index < arr1.len() {
                if arr1[arr1_index] == arr2[arr2_index] {
                    result.push(arr1[arr1_index]);
                    arr1.remove(arr1_index);
                } else {
                    arr1_index += 1;
                }
            }
            arr2_index += 1;
            arr1_index = 0;
        }
        arr1.sort();
        result.append(&mut arr1);
        result
    }
}